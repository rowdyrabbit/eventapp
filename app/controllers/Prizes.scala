package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json.Json
import models.Prize

object Prizes extends Controller {

  def list = Action {
    implicit val prizesFormat = Json.format[Prize]

    val prizes = Json.toJson(Prize.all())
    Ok(prizes).withHeaders("Access-Control-Allow-Origin" -> "*")
  }
}