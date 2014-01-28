package models

case class Event(id: String, address:Address, eventDays: Array[EventDay])

object EventJsonFormats {
  import play.api.libs.json.Json

  implicit val eventDayFormat = Json.format[EventDay]
  implicit val addressFormat = Json.format[Address]
  implicit val eventFormat = Json.format[Event]
}
