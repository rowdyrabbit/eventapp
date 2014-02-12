package controllers

import play.api.mvc._
import play.api.libs.json.Json
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent.Future
import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.json.collection.JSONCollection
import reactivemongo.api.Cursor
import models.ProgramDays
import models.ProgramDaysJsonFormats._
import utils.WebUtils._
import models.ProgramDays
import play.modules.reactivemongo.json.collection.JSONCollection

object Program extends Controller with MongoController {

  def collection: JSONCollection = db.collection[JSONCollection]("programDays")

  def list = Action.async {
    val cursor: Cursor[ProgramDays] = collection.
      find(Json.obj()).
      cursor[ProgramDays]

    val futureProgramList: Future[List[ProgramDays]] = cursor.collect[List]()

    futureProgramList.map { programDays =>
      Ok(Json.toJson(programDays)).withHeaders(CORSHeader)
    }
  }
}