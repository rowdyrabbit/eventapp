package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json.Json
import models.{Timeslot, ProgramDays}

object Program extends Controller {

  def list = Action {
    implicit val timeslotFormat = Json.format[Timeslot]
    implicit val scheduleFormat = Json.format[ProgramDays]

    val programs = Json.toJson(ProgramDays.all())
    Ok(programs).withHeaders("Access-Control-Allow-Origin" -> "*")
  }
}