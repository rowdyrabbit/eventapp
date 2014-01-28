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

object Events extends Controller with MongoController {

  def collection: JSONCollection = db.collection[JSONCollection]("events")

  def show(id:String) = Action.async {
//    Logger.info("Requesting event by id %", id);

    // let's do our query
    val cursor: Cursor[JsObject] = collection.
      // find all people with name `name`
      find(Json.obj("id" -> id)).
      // sort them by creation date
//      sort(Json.obj("created" -> -1)).
      // perform the query and get a cursor of JsObject
      cursor[JsObject]

    // gather all the JsObjects in a list
    val futureEventList: Future[List[JsObject]] = cursor.collect[List]()

    futureEventList.map { events =>
      Ok(Json.toJson(events)).withHeaders("Access-Control-Allow-Origin" -> "*")
    }
//    // transform the list into a JsArray
//    val futureEventsJsonArray: Future[JsArray] = futureEventList.map { events =>
//      Json.arr(events)
//    }
//
//    // everything's ok! Let's reply with the array
//    futureEventsJsonArray.map { events =>
//      Ok(events).withHeaders("Access-Control-Allow-Origin" -> "*")
//    }
  }

  def list = Action.async {
    Logger.info("Requesting events");

    val cursor: Cursor[Event] = collection.
      find(Json.obj()).
      cursor[Event]

    val futureEventList: Future[List[Event]] = cursor.collect[List]()

    futureEventList.map { events =>
      Ok(Json.toJson(events)).withHeaders("Access-Control-Allow-Origin" -> "*")
    }
  }
}
