package models

case class Prize(name: String, desc: String)

object PrizeJsonFormats {
  import play.api.libs.json.Json

  // Generates Writes and Reads for Feed and User thanks to Json Macros
  implicit val prizeFormat = Json.format[Prize]
}