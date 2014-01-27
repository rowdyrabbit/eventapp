package models

case class ProgramDays(date: String, program: Array[Timeslot])

object ProgramDaysJsonFormats {
  import play.api.libs.json.Json

  implicit val timeslotFormat = Json.format[Timeslot]
  implicit val programFormat = Json.format[ProgramDays]
}