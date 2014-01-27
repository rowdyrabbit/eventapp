package models

case class ProgramDays(date: String, program: Array[Timeslot])

object ProgramDays {
  //hardcoded list for now until we integrate with a data store
  def all(): List[ProgramDays] = List(
    ProgramDays("FRIDAY 21st MARCH, 2014",
      Array(Timeslot("Guest Arrival & Registration", "18:00"),
        Timeslot("Welcome & Lightening Talks", "18:30"),
        Timeslot("Pitches & Group Formation", "19:00"),
        Timeslot("Dinner", "19:30"),
        Timeslot("Start Hacking", "20:00"),
        Timeslot("Home Time", "24:00"))),
    ProgramDays("SATURDAY 22nd MARCH, 2014",
      Array(Timeslot("Coffee & Hacking", "09:00"),
        Timeslot("Morning Tea", "10:00"),
        Timeslot("Lunch", "12:00"),
        Timeslot("Team Presentations", "17:00"),
        Timeslot("Judging and Prizes", "17:30"),
        Timeslot("Party Time @ nearby bar", "18:80")))
  )

}