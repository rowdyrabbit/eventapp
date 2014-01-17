package models

case class Prize(name: String, desc: String)

object Prize {
  //hardcoded list for now until we integrate with a data store
  def all(): List[Prize] = List(
    Prize("Best Use of Search", "sponsored by Google"),
    Prize("Best Use of Social Media", "sponsored by Microsoft"),
    Prize("People's Choice", "as voted by audience")
  )
}