package controllers

import play.api.mvc._
import play.api.libs.json.Json
import play.api.libs.concurrent.Execution.Implicits._
import models.Prize
import scala.concurrent.Future
import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.json.collection.JSONCollection
import reactivemongo.api.Cursor
import models.PrizeJsonFormats._
import utils.WebUtils._

object Prizes extends Controller with MongoController {

  def collection: JSONCollection = db.collection[JSONCollection]("prizes")

  def list = Action.async {
    val cursor: Cursor[Prize] = collection.
      find(Json.obj()).
      cursor[Prize]

    val futurePrizeList: Future[List[Prize]] = cursor.collect[List]()

    futurePrizeList.map { prizes =>
      Ok(Json.toJson(prizes)).withHeaders(CORSHeader)
    }
  }
}