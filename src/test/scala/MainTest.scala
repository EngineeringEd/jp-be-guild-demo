import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatest.prop.{TableDrivenPropertyChecks, TableFor3}
import demo.{CleansingStateEnum, Listing, ListingStatusEnum}
import org.scalatest.matchers.must.Matchers.{be, must}

class MainTest extends AnyFunSuiteLike with TableDrivenPropertyChecks {
  val listingStates: TableFor3[String, Listing, String] = Table(
    ("case", "listing", "result"),
    ("active listing", Listing(true, false, false, cleansingState = CleansingStateEnum.Approved), ListingStatusEnum.Active.value),
    ("hidden listing", Listing(false, false, true, cleansingState = CleansingStateEnum.New), ListingStatusEnum.Hidden.value),
    ("deleted listing", Listing(false, true, true, cleansingState = CleansingStateEnum.Purged), ListingStatusEnum.Deleted.value),
//    ("pending listing", Listing(false, true, false, cleansingState = CleansingStateEnum.Pending), ListingStatusEnum.Pending.value),
  )

  forAll(listingStates) { (kase, listing, expected) =>
    test(kase) {
      listing.getStatus must be(expected)
    }
  }
}
