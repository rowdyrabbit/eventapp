package controllers

import play.api.mvc._
import play.api.libs.json.Json
import play.api.libs.concurrent.Execution.Implicits._
import scala.concurrent.Future
import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.json.collection.JSONCollection
import reactivemongo.api.Cursor
import models.MenuItem
import models.MenuItemJsonFormats._
import utils.WebUtils._
import models.MenuItem
import play.modules.reactivemongo.json.collection.JSONCollection

object Menu extends Controller with MongoController {

  def collection: JSONCollection = db.collection[JSONCollection]("menuItems")

  def list = Action.async {
    val cursor: Cursor[MenuItem] = collection.
      find(Json.obj()).
      cursor[MenuItem]

    val futureMenuList: Future[List[MenuItem]] = cursor.collect[List]()

    futureMenuList.map { menuItems =>
      Ok(Json.toJson(menuItems)).withHeaders(CORSHeader)
    }
  }
}