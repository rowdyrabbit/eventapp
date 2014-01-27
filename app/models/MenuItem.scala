package models

case class MenuItem(text: String, iconClass: String, colour: String, link: String)

object MenuItemJsonFormats {
  import play.api.libs.json.Json

  implicit val menuItemsFormat = Json.format[MenuItem]
}