package models

case class Credit(name: String, desc: String)

object CreditJsonFormats {
  import play.api.libs.json.Json

  // Generates Writes and Reads for Feed and User thanks to Json Macros
  implicit val creditFormat = Json.format[Credit]
}