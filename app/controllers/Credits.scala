package controllers

import play.api.mvc._
import play.api.libs.json.Json
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent.Future
import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.json.collection.JSONCollection
import reactivemongo.api.Cursor
import models.Credit
import models.CreditJsonFormats._
import play.Logger
import utils.WebUtils._
import models.Credit
import play.modules.reactivemongo.json.collection.JSONCollection

object Credits extends Controller with MongoController {

  def collection: JSONCollection = db.collection[JSONCollection]("credits")

  def list = Action.async {
    Logger.info("Requesting credits");

    val cursor: Cursor[Credit] = collection.
      find(Json.obj()).
      cursor[Credit]

    val futureCreditList: Future[List[Credit]] = cursor.collect[List]()

    futureCreditList.map { credits =>
      Ok(Json.toJson(credits)).withHeaders(CORSHeader)
    }
  }
}