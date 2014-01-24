package models

case class MenuItem(text: String, iconClass: String, colour: String, link: String)

object MenuItemJsonFormats {
  import play.api.libs.json.Json

  // Generates Writes and Reads for Feed and User thanks to Json Macros
  implicit val menuItemsFormat = Json.format[MenuItem]
}