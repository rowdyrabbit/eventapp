package models

case class Sponsor(name: String, src: String, link: String, order: Int)

object SponsorJsonFormats {
  import play.api.libs.json.Json

  implicit val sponsorFormat = Json.format[Sponsor]
}
