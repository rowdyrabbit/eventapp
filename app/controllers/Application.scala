package controllers

import play.api.mvc._

object Application extends Controller {

  //Placeholder until we have a web interface.
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

}