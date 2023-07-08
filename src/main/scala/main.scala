import demo.{CleansingStateEnum, Listing}

object main {
  def main(args: Array[String]): Unit = {
    val listing = Listing(
      active = true,
      isDeleted = false,
      isHidden = false,
      title = "My Awesome Listing",
      cleansingState = CleansingStateEnum.Approved
    )

    println(listing.getStatus)
  }
}
