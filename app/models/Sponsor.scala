package models


case class Sponsor(id: Long, eventId: Long, name: String, src: String, link: String)


object Sponsor {

  //hardcoded list for now until we integrate with a data store
  def all(): List[Sponsor] = List(
    Sponsor(1, 1, "Google", "img/google.jpg", "www.google.com.au"),
    Sponsor(2, 1, "Atlassian", "img/google.jpg", "www.atlassian.com"),
    Sponsor(3, 1, "Github", "img/google.jpg", "www.github.com"),
    Sponsor(4, 1, "Mi9", "img/google.jpg", "www.google.com.au")
  )
}