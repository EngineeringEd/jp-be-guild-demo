package demo

enum ListingStatusEnum(val value: String) {
  case Active extends ListingStatusEnum("ACTIVE")
  case Deleted extends ListingStatusEnum("DELETED")
  case Hidden extends ListingStatusEnum("HIDDEN")
  case Pending extends ListingStatusEnum("PENDING")
}