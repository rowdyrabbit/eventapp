package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json.Json
import models.Sponsor

object Sponsors extends Controller {

  def list = Action {
    implicit val sponsorFormat = Json.format[Sponsor]

    val sponsors = Json.toJson(Sponsor.all())
    Ok(sponsors).withHeaders("Access-Control-Allow-Origin" -> "*")
  }

}