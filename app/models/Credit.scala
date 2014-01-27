package models

case class Credit(name: String, desc: String)

object CreditJsonFormats {
  import play.api.libs.json.Json

  implicit val creditFormat = Json.format[Credit]
}