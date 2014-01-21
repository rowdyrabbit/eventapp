package models

case class Sponsor(name: String, src: String, link: String)

object SponsorJsonFormats {
  import play.api.libs.json.Json

  // Generates Writes and Reads for Feed and User thanks to Json Macros
  implicit val sponsorFormat = Json.format[Sponsor]
}
