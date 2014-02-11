package models

case class Prize(name: String, desc: String, order: Int)

object PrizeJsonFormats {
  import play.api.libs.json.Json

  implicit val prizeFormat = Json.format[Prize]
}