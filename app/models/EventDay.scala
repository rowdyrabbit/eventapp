package models

case class EventDay(eventDate: String, startTime: String, endTime: String)

object EventDayJsonFormats {
  import play.api.libs.json.Json

  implicit val eventDayFormat = Json.format[EventDay]
}
