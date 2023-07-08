package demo

case class Listing(
  active: Boolean,
  isDeleted: Boolean,
  isHidden: Boolean,
  title: String = "Test Listing",
  var cleansingState: CleansingStateEnum = CleansingStateEnum.New
) {
  def getStatus: String = {
    return unapply(this) match {
      case (true, false, false, CleansingStateEnum.Approved) => ListingStatusEnum.Active.value
      case (false, true, true, CleansingStateEnum.Purged) => ListingStatusEnum.Deleted.value
      case (false, false, true, CleansingStateEnum.Approved | CleansingStateEnum.New) => ListingStatusEnum.Hidden.value
    }
  }

  def unapply(listing: Listing): (Boolean, Boolean, Boolean, CleansingStateEnum) = {
    return (listing.active, listing.isDeleted, listing.isHidden, listing.cleansingState)
  }
}