package controllers

import play.api.mvc._
import play.api.libs.json.{JsObject, JsArray, Json}
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent.Future
import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.json.collection.JSONCollection
import reactivemongo.api.Cursor
import models.{Event}
import models.EventJsonFormats._
import play.Logger
import utils.WebUtils._
import play.api.libs.json.JsObject
import models.Event
import play.modules.reactivemongo.json.collection.JSONCollection

object Events extends Controller with MongoController {

  def collection: JSONCollection = db.collection[JSONCollection]("events")

  def show(id:String) = Action.async {

    val cursor: Cursor[JsObject] = collection.
      find(Json.obj("id" -> id)).
      cursor[JsObject]

    val futureEventList: Future[List[JsObject]] = cursor.collect[List]()

    futureEventList.map { events =>
      Ok(Json.toJson(events)).withHeaders(CORSHeader)
    }
  }

  def list = Action.async {
    Logger.info("Requesting events");

    val cursor: Cursor[Event] = collection.
      find(Json.obj()).
      cursor[Event]

    val futureEventList: Future[List[Event]] = cursor.collect[List]()

    futureEventList.map { events =>
      Ok(Json.toJson(events)).withHeaders(CORSHeader)
    }
  }
}
