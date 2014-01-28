package models

case class Address(addressLine1: String, addressLine2: String)

object AddressJsonFormats {
  import play.api.libs.json.Json

  implicit val addressFormat = Json.format[Address]
}
