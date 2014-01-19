package controllers

import play.api.mvc._
import play.api.libs.json.{JsArray, JsObject, Json}
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent.Future
import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.json.collection.JSONCollection
import reactivemongo.api.Cursor
import models.Sponsor
import models.JsonFormats._

object Sponsors extends Controller with MongoController {

  def collection: JSONCollection = db.collection[JSONCollection]("sponsors")


  def list = Action.async {
    val cursor: Cursor[Sponsor] = collection.
      find(Json.obj()).
      cursor[Sponsor]

    val futureSponsorList: Future[List[Sponsor]] = cursor.collect[List]()

    futureSponsorList.map { sponsors =>
      Ok(Json.toJson(sponsors)).withHeaders("Access-Control-Allow-Origin" -> "*")
    }
  }

}

