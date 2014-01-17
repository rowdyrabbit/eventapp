package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json.Json
import models.Schedule

object Program extends Controller {

  def list = Action {
    implicit val scheduleFormat = Json.format[Schedule]

    val programs = Json.toJson(Schedule.all())
    Ok(programs).withHeaders("Access-Control-Allow-Origin" -> "*")
  }
}