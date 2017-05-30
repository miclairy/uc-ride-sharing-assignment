$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("addRoute.feature");
formatter.feature({
  "line": 1,
  "name": "Create Route",
  "description": "",
  "id": "create-route",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Jo makes a route",
  "description": "",
  "id": "create-route;jo-makes-a-route",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Jo is a driver and wants to make a route",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "there are more than 1 stop point",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "jo creates route by adding stop points",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "a new route is stored with the stop points.",
  "keyword": "Then "
});
formatter.match({
  "location": "addRouteSteps.joIsADriverAndWantsToMakeARoute()"
});
formatter.result({
  "duration": 80881025,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 20
    }
  ],
  "location": "addRouteSteps.thereAreMoreThanStopPoint(int)"
});
formatter.result({
  "duration": 1382461,
  "status": "passed"
});
formatter.match({
  "location": "addRouteSteps.joCreatesRouteByAddingStopPoints()"
});
formatter.result({
  "duration": 2821110,
  "status": "passed"
});
formatter.match({
  "location": "addRouteSteps.aNewRouteIsStoredWithTheStopPoints()"
});
formatter.result({
  "duration": 203117,
  "status": "passed"
});
formatter.uri("addTrip.feature");
formatter.feature({
  "line": 1,
  "name": "make trip",
  "description": "As ​​driver​​, I want to ​​add trips so that I can set up all the information for the rides\r\nthat I will share later on",
  "id": "make-trip",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Jo makes a trip",
  "description": "",
  "id": "make-trip;jo-makes-a-trip",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "jo is a driver making a trip",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "jo has some routes",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Jo registered a car.",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Jo creates a trip by defining it to be his only route \"to university\" 1500 each stop point 15 minutes after the previous",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "that the trip is recurrent so it repeats every \"Wednesday\" until 6th \"May\".",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "the trip is displayed to jo with all information.",
  "keyword": "Then "
});
formatter.match({
  "location": "makeTripSteps.joIsADriverMakingATrip()"
});
formatter.result({
  "duration": 49277,
  "status": "passed"
});
formatter.match({
  "location": "makeTripSteps.joHasSomeRoutes()"
});
formatter.result({
  "duration": 162855,
  "status": "passed"
});
formatter.match({
  "location": "makeTripSteps.joRegisteredACar()"
});
formatter.result({
  "duration": 25859321,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "to university",
      "offset": 55
    },
    {
      "val": "1500",
      "offset": 70
    },
    {
      "val": "15",
      "offset": 91
    }
  ],
  "location": "makeTripSteps.joCreatesATripByDefiningItToBeHisOnlyRouteEachStopPointMinutesAfterThePrevious(String,int,int)"
});
formatter.result({
  "duration": 840715,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Wednesday",
      "offset": 48
    },
    {
      "val": "6",
      "offset": 65
    },
    {
      "val": "May",
      "offset": 70
    }
  ],
  "location": "makeTripSteps.thatTheTripIsRecurrentSoItRepeatsEveryUntilTh(String,int,String)"
});
formatter.result({
  "duration": 250291,
  "status": "passed"
});
formatter.match({
  "location": "makeTripSteps.theTripIsDisplayedToJoWithAllInformation()"
});
formatter.result({
  "duration": 24939,
  "status": "passed"
});
formatter.uri("bookRide.feature");
formatter.feature({
  "line": 1,
  "name": "Book a ride",
  "description": "As ​​passenger​​, I want to ​​book a ride​​ so that I can get to where I am going.",
  "id": "book-a-ride",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Sally wants to book a ride",
  "description": "",
  "id": "book-a-ride;sally-wants-to-book-a-ride",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Sally is a passenger",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "sally has selected a ride",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "sally books the ride",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "sally will be expected on the ride and the available seats decreases",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "she will know that she booked the ride",
  "keyword": "And "
});
formatter.match({
  "location": "rideDetailsSteps.sallyIsAPassenger()"
});
formatter.result({
  "duration": 27342,
  "status": "passed"
});
formatter.match({
  "location": "bookRideSteps.sallyHasSelectedARide()"
});
formatter.result({
  "duration": 1146292,
  "status": "passed"
});
formatter.match({
  "location": "bookRideSteps.sallyBooksTheRide()"
});
formatter.result({
  "duration": 85032,
  "status": "passed"
});
formatter.match({
  "location": "bookRideSteps.sallyWillBeExpectedOnTheRideAndTheAvailableSeatsDecreases()"
});
formatter.result({
  "duration": 72113,
  "status": "passed"
});
formatter.match({
  "location": "bookRideSteps.sheWillKnowThatSheBookedTheRide()"
});
formatter.result({
  "duration": 15324,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Sally wants to book the same ride",
  "description": "",
  "id": "book-a-ride;sally-wants-to-book-the-same-ride",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "Sally is a passenger",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "sally has booked a ride",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "sally goes to book the ride again",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "nothing happens and she is not included again.",
  "keyword": "Then "
});
formatter.match({
  "location": "rideDetailsSteps.sallyIsAPassenger()"
});
formatter.result({
  "duration": 19230,
  "status": "passed"
});
formatter.match({
  "location": "bookRideSteps.sallyHasBookedARide()"
});
formatter.result({
  "duration": 68206,
  "status": "passed"
});
formatter.match({
  "location": "bookRideSteps.sallyGoesToBookTheRideAgain()"
});
formatter.result({
  "duration": 12920,
  "status": "passed"
});
formatter.match({
  "location": "bookRideSteps.nothingHappensAndSheIsNotIncludedAgain()"
});
formatter.result({
  "duration": 15624,
  "status": "passed"
});
formatter.uri("cancelBooking.feature");
formatter.feature({
  "line": 1,
  "name": "Cancel booking",
  "description": "As a ​​passenger​​, I want to ​​cancel a booked ride so that the driver will be informed and the seat\r\ncan be used by someone else.",
  "id": "cancel-booking",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Sally cancels a booking",
  "description": "",
  "id": "cancel-booking;sally-cancels-a-booking",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "sally has booked a ride and wants to cancel it",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "sally cancels the booking because \"she is busy\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "the drivers car is available again if it wasn\u0027t before with updated available seats",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "the driver is notified of the cancellation",
  "keyword": "And "
});
formatter.match({
  "location": "cancelBookedRideSteps.sallyHasBookedARideAndWantsToCancelIt()"
});
formatter.result({
  "duration": 188094,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "she is busy",
      "offset": 35
    }
  ],
  "location": "cancelBookedRideSteps.sallyCancelsTheBookingBecause(String)"
});
formatter.result({
  "duration": 89841,
  "status": "passed"
});
formatter.match({
  "location": "cancelBookedRideSteps.theDriversCarIsAvailableAgainIfItWasnTBeforeWithUpdatedAvailableSeats()"
});
formatter.result({
  "duration": 41165,
  "status": "passed"
});
formatter.match({
  "location": "cancelBookedRideSteps.theDriverIsNotifiedOfTheCancellation()"
});
formatter.result({
  "duration": 69709,
  "status": "passed"
});
formatter.uri("cancelRide.feature");
formatter.feature({
  "line": 1,
  "name": "Cancel Ride",
  "description": "As a ​​driver​​, I want to ​​cancel a ride so the passengers will be notified that I will no longer be\r\npicking them up",
  "id": "cancel-ride",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Jo cancels a ride",
  "description": "",
  "id": "cancel-ride;jo-cancels-a-ride",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Jo is a driver who wants to cancel a ride",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Jo has a trip which he has shared",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "there are passengers booked on the ride",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "jo selects to cancel the ride",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the passengers are notified",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "the ride is no longer available",
  "keyword": "And "
});
formatter.match({
  "location": "cancelRideSteps.joIsADriverWhoWantsToCancelARide()"
});
formatter.result({
  "duration": 257202,
  "status": "passed"
});
formatter.match({
  "location": "cancelRideSteps.joHasATripWhichHeHasShared()"
});
formatter.result({
  "duration": 362066,
  "status": "passed"
});
formatter.match({
  "location": "cancelRideSteps.thereArePassengersBookedOnTheRide()"
});
formatter.result({
  "duration": 48977,
  "status": "passed"
});
formatter.match({
  "location": "cancelRideSteps.joSelectsToCancelTheRide()"
});
formatter.result({
  "duration": 33051,
  "status": "passed"
});
formatter.match({
  "location": "cancelRideSteps.thePassengersAreNotified()"
});
formatter.result({
  "duration": 41464,
  "status": "passed"
});
formatter.match({
  "location": "cancelRideSteps.theRideIsNoLongerAvailable()"
});
formatter.result({
  "duration": 31549,
  "status": "passed"
});
formatter.uri("createAccount.feature");
formatter.feature({
  "line": 1,
  "name": "Create an Account",
  "description": "As a ​​potential user​​, I want to ​​create an account​​ so that I can use the system effectively (see story 3)",
  "id": "create-an-account",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "jo creates a driver account",
  "description": "",
  "id": "create-an-account;jo-creates-a-driver-account",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "jo clicked become driver",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "jo enters \"jb34\", \"jo\", \"6 hare street\", \"027555555\" and \"jb34@uclive.ac.nz\" and he uploads a photo and enters the password \"password1\" twice",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the email and password are verified and he is asked for his drivers license information",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "jo enters type \"full\", \"FR123456\", \"02/01/2010\", \"02/01/2020\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "it is verified he can carry passengers",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "his details are stored and account is created",
  "keyword": "And "
});
formatter.match({
  "location": "createAccountSteps.joClickedBecomeDriver()"
});
formatter.result({
  "duration": 80225,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "jb34",
      "offset": 11
    },
    {
      "val": "jo",
      "offset": 19
    },
    {
      "val": "6 hare street",
      "offset": 25
    },
    {
      "val": "027555555",
      "offset": 42
    },
    {
      "val": "jb34@uclive.ac.nz",
      "offset": 58
    },
    {
      "val": "password1",
      "offset": 125
    }
  ],
  "location": "createAccountSteps.joEntersAndAndHeUploadsAPhotoAndEntersThePasswordTwice(String,String,String,String,String,String)"
});
formatter.result({
  "duration": 128000,
  "status": "passed"
});
formatter.match({
  "location": "createAccountSteps.theEmailAndPasswordAreVerifiedAndHeIsAskedForHisDriversLicenseInformation()"
});
formatter.result({
  "duration": 305578,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "full",
      "offset": 16
    },
    {
      "val": "FR123456",
      "offset": 24
    },
    {
      "val": "02/01/2010",
      "offset": 36
    },
    {
      "val": "02/01/2020",
      "offset": 50
    }
  ],
  "location": "createAccountSteps.joEntersType(String,String,String,String)"
});
formatter.result({
  "duration": 5193018,
  "status": "passed"
});
formatter.match({
  "location": "createAccountSteps.itIsVerifiedHeCanCarryPassengers()"
});
formatter.result({
  "duration": 46874,
  "status": "passed"
});
formatter.match({
  "location": "createAccountSteps.hisDetailsAreStoredAndAccountIsCreated()"
});
formatter.result({
  "duration": 27306983,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "sally creates a passenger account",
  "description": "",
  "id": "create-an-account;sally-creates-a-passenger-account",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "sally clicked to become a passenger",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "sally enters \"sal34\", \"sally\", \"8 bear street\", \"021444556\" and \"sal34@canterbury.ac.nz\" and she uploads a photo and enters the password \"funlover2\" twice",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "the email and password are verified and her account is created",
  "keyword": "Then "
});
formatter.match({
  "location": "createAccountSteps.sallyClickedToBecomeAPassenger()"
});
formatter.result({
  "duration": 21333,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sal34",
      "offset": 14
    },
    {
      "val": "sally",
      "offset": 23
    },
    {
      "val": "8 bear street",
      "offset": 32
    },
    {
      "val": "021444556",
      "offset": 49
    },
    {
      "val": "sal34@canterbury.ac.nz",
      "offset": 65
    },
    {
      "val": "funlover2",
      "offset": 138
    }
  ],
  "location": "createAccountSteps.sallyEntersAndAndSheUploadsAPhotoAndEntersThePasswordTwice(String,String,String,String,String,String)"
});
formatter.result({
  "duration": 58591,
  "status": "passed"
});
formatter.match({
  "location": "createAccountSteps.theEmailAndPasswordAreVerifiedAndHerAccountIsCreated()"
});
formatter.result({
  "duration": 23185741,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "sally forgets she already signed up and signs up again",
  "description": "",
  "id": "create-an-account;sally-forgets-she-already-signed-up-and-signs-up-again",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "sally is already signed up",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "sally enters \"sal34\", \"sally\", \"8 bear street\", \"021444556\" and \"sal34@canterbury.ac.nz\" and she uploads a photo and enters the password \"funlover2\" twice",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "the email fails verification and she is told the email is already in use",
  "keyword": "Then "
});
formatter.match({
  "location": "createAccountSteps.sallyIsAlreadySignedUp()"
});
formatter.result({
  "duration": 77821,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sal34",
      "offset": 14
    },
    {
      "val": "sally",
      "offset": 23
    },
    {
      "val": "8 bear street",
      "offset": 32
    },
    {
      "val": "021444556",
      "offset": 49
    },
    {
      "val": "sal34@canterbury.ac.nz",
      "offset": 65
    },
    {
      "val": "funlover2",
      "offset": 138
    }
  ],
  "location": "createAccountSteps.sallyEntersAndAndSheUploadsAPhotoAndEntersThePasswordTwice(String,String,String,String,String,String)"
});
formatter.result({
  "duration": 75117,
  "status": "passed"
});
formatter.match({
  "location": "createAccountSteps.theEmailFailsVerificationAndSheIsToldTheEmailIsAlreadyInUse()"
});
formatter.result({
  "duration": 2015250,
  "status": "passed"
});
formatter.uri("createStopPoints.feature");
formatter.feature({
  "line": 1,
  "name": "create stop points",
  "description": "As ​​driver​​, I want to ​​create stop points so I can specify where I will pick up or drop\r\noff passengers",
  "id": "create-stop-points",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Bob adds stop point",
  "description": "",
  "id": "create-stop-points;bob-adds-stop-point",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "bob is a driver",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "bob creates a stop point at 21 \"Halswell Junction Road\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "the street address is stored as a stop point",
  "keyword": "Then "
});
formatter.match({
  "location": "createStopPointSteps.bob_is_a_driver()"
});
formatter.result({
  "duration": 70911,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "21",
      "offset": 28
    },
    {
      "val": "Halswell Junction Road",
      "offset": 32
    }
  ],
  "location": "createStopPointSteps.bob_creates_a_stop_point_at(int,String)"
});
formatter.result({
  "duration": 648113,
  "status": "passed"
});
formatter.match({
  "location": "createStopPointSteps.the_street_address_is_stored_as_a_stop_point()"
});
formatter.result({
  "duration": 51681,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Sally adds a stop point already made",
  "description": "",
  "id": "create-stop-points;sally-adds-a-stop-point-already-made",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "Sally is a driver",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "Sally creates a stop point at 21 \"Halswell Junction Road\" after bob",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "a new stop point is not made",
  "keyword": "Then "
});
formatter.match({
  "location": "createStopPointSteps.sally_is_a_driver()"
});
formatter.result({
  "duration": 25239,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "21",
      "offset": 30
    },
    {
      "val": "Halswell Junction Road",
      "offset": 34
    }
  ],
  "location": "createStopPointSteps.sally_creates_a_stop_point_at_after_bob(int,String)"
});
formatter.result({
  "duration": 76319,
  "status": "passed"
});
formatter.match({
  "location": "createStopPointSteps.a_new_stop_point_is_not_made()"
});
formatter.result({
  "duration": 11117,
  "status": "passed"
});
formatter.uri("editAccount.feature");
formatter.feature({
  "line": 1,
  "name": "Edit Account",
  "description": "",
  "id": "edit-account",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Sally edits her account",
  "description": "",
  "id": "edit-account;sally-edits-her-account",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Sally has an account",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Sally changes her name to \"sophie\" and her phone number to \"0275559999\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Her details are changed",
  "keyword": "Then "
});
formatter.match({
  "location": "editAccountSteps.sallyHasAnAccount()"
});
formatter.result({
  "duration": 76018,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sophie",
      "offset": 27
    },
    {
      "val": "0275559999",
      "offset": 60
    }
  ],
  "location": "editAccountSteps.sallyChangesHerNameToAndHerPhoneNumberTo(String,String)"
});
formatter.result({
  "duration": 47174,
  "status": "passed"
});
formatter.match({
  "location": "editAccountSteps.herDetailsAreChanged()"
});
formatter.result({
  "duration": 21333,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Sally edits her account",
  "description": "",
  "id": "edit-account;sally-edits-her-account",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "Sally has an account",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "Sally changes her uc id to \"sph23\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Her details are not changed",
  "keyword": "Then "
});
formatter.match({
  "location": "editAccountSteps.sallyHasAnAccount()"
});
formatter.result({
  "duration": 14723,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sph23",
      "offset": 28
    }
  ],
  "location": "editAccountSteps.sallyChangesHerUcIdTo(String)"
});
formatter.result({
  "duration": 46873,
  "status": "passed"
});
formatter.match({
  "location": "editAccountSteps.herDetailsAreNotChanged()"
});
formatter.result({
  "duration": 18630,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Jo edits his account",
  "description": "",
  "id": "edit-account;jo-edits-his-account",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "Jo has a driver account",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "Jo goes to edit his account and changes his license expiration to next year",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "his new license information is stored",
  "keyword": "Then "
});
formatter.match({
  "location": "editAccountSteps.joHasADriverAccount()"
});
formatter.result({
  "duration": 80827,
  "status": "passed"
});
formatter.match({
  "location": "editAccountSteps.joGoesToEditHisAccountAndChangesHisLicenseExpirationToNextYear()"
});
formatter.result({
  "duration": 24939,
  "status": "passed"
});
formatter.match({
  "location": "editAccountSteps.hisNewLicenseInformationIsStored()"
});
formatter.result({
  "duration": 24038,
  "status": "passed"
});
formatter.uri("expirationNotification.feature");
formatter.feature({
  "line": 1,
  "name": "Nofity User of expiration\u0027",
  "description": "As a ​​driver​​, I want to be ​​notified ​​if my drivers licence, WOF or registration is about to expire so I\r\ncan renew them on time.",
  "id": "nofity-user-of-expiration\u0027",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "license expires in one month",
  "description": "",
  "id": "nofity-user-of-expiration\u0027;license-expires-in-one-month",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Jo has an account",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "his license expires in one month",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "logs in",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "he will be notified that his license going to expire.",
  "keyword": "Then "
});
formatter.match({
  "location": "NotifyUserExpirationSteps.joHasAnAccount()"
});
formatter.result({
  "duration": 52883,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.hisLicenseExpiresInOneMonth()"
});
formatter.result({
  "duration": 66404,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.logsIn()"
});
formatter.result({
  "duration": 12620,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.heWillBeNotifiedThatHisLicenseGoingToExpire()"
});
formatter.result({
  "duration": 125897,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "WOF expires in one month",
  "description": "",
  "id": "nofity-user-of-expiration\u0027;wof-expires-in-one-month",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "Jo has an account",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "his WOF expires in one month",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "logs in",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "he will be notified that s WOF is going to expire.",
  "keyword": "Then "
});
formatter.match({
  "location": "NotifyUserExpirationSteps.joHasAnAccount()"
});
formatter.result({
  "duration": 20432,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.hisWOFExpiresInOneMonth()"
});
formatter.result({
  "duration": 68507,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.logsIn()"
});
formatter.result({
  "duration": 10215,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.heWillBeNotifiedThatSWOFIsGoingToExpire()"
});
formatter.result({
  "duration": 159249,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "registration and licence expires in one month",
  "description": "",
  "id": "nofity-user-of-expiration\u0027;registration-and-licence-expires-in-one-month",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "Jo has an account",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "his registration expires in one month",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "his license expires in one month",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "logs in",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "he will be notified that the registration and license are going to expire.",
  "keyword": "Then "
});
formatter.match({
  "location": "NotifyUserExpirationSteps.joHasAnAccount()"
});
formatter.result({
  "duration": 22536,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.hisRegistrationExpiresInOneMonth()"
});
formatter.result({
  "duration": 56188,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.hisLicenseExpiresInOneMonth()"
});
formatter.result({
  "duration": 27042,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.logsIn()"
});
formatter.result({
  "duration": 7512,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.heWillBeNotifiedThatTheRegistrationAndLicenseAreGoingToExpire()"
});
formatter.result({
  "duration": 76920,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "licence expires in 3 weeks",
  "description": "",
  "id": "nofity-user-of-expiration\u0027;licence-expires-in-3-weeks",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "Jo has an account",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "his registration expires in 3 weeks",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "logs in",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "he will not be notified that it is going to expire.",
  "keyword": "Then "
});
formatter.match({
  "location": "NotifyUserExpirationSteps.joHasAnAccount()"
});
formatter.result({
  "duration": 22234,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 28
    }
  ],
  "location": "NotifyUserExpirationSteps.hisRegistrationExpiresInWeeks(int)"
});
formatter.result({
  "duration": 158648,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.logsIn()"
});
formatter.result({
  "duration": 9916,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.heWillNotBeNotifiedThatItIsGoingToExpire()"
});
formatter.result({
  "duration": 152338,
  "status": "passed"
});
formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "Login",
  "description": "As a ​​user​​, I want to ​​log into my account​​ so I can use the system.",
  "id": "login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Jo successfully logs in to his account",
  "description": "",
  "id": "login;jo-successfully-logs-in-to-his-account",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "jo has an account",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "he enters the correct email and password",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "he is let into his account with his trips etc",
  "keyword": "Then "
});
formatter.match({
  "location": "loginSteps.joHasAnAccount()"
});
formatter.result({
  "duration": 24276146,
  "status": "passed"
});
formatter.match({
  "location": "loginSteps.heEntersTheCorrectEmailAndPassword()"
});
formatter.result({
  "duration": 41164,
  "status": "passed"
});
formatter.match({
  "location": "loginSteps.heIsLetIntoHisAccountWithHisTripsEtc()"
});
formatter.result({
  "duration": 21622098,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Jo fails to get into his account",
  "description": "",
  "id": "login;jo-fails-to-get-into-his-account",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "jo doesn\u0027t have an account",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "jo tries to log in",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "he is told the credentials are wrong",
  "keyword": "Then "
});
formatter.match({
  "location": "loginSteps.joDoesnTHaveAnAccount()"
});
formatter.result({
  "duration": 23990400,
  "status": "passed"
});
formatter.match({
  "location": "loginSteps.joTriesToLogIn()"
});
formatter.result({
  "duration": 20732,
  "status": "passed"
});
formatter.match({
  "location": "loginSteps.heIsToldTheCredentialsAreWrong()"
});
formatter.result({
  "duration": 2668171,
  "status": "passed"
});
formatter.uri("registerCar.feature");
formatter.feature({
  "line": 1,
  "name": "Register Car",
  "description": "As a ​ driver​ , I want to ​ register a car​ so that it can be used for sharing a ride.",
  "id": "register-car",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Jo registers car",
  "description": "",
  "id": "register-car;jo-registers-car",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Jo is a driver",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Jo has a car with 5 seats and type is \"Small Car\"",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "license plate \"YTZ235\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "year 2001",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "the car colour is \"green\", model is \"Subaru\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "the car is registered",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the car\u0027s attributes of year 2001, license plate \"YTZ235\", colour \"green\" and 5 seats are stored.",
  "keyword": "Then "
});
formatter.match({
  "location": "registerCarSteps.jo_is_a_driver()"
});
formatter.result({
  "duration": 65202,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 18
    },
    {
      "val": "Small Car",
      "offset": 39
    }
  ],
  "location": "registerCarSteps.jo_has_a_car_with_seats_and_type_is(int,String)"
});
formatter.result({
  "duration": 97352,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "YTZ235",
      "offset": 15
    }
  ],
  "location": "registerCarSteps.license_plate(String)"
});
formatter.result({
  "duration": 25840,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2001",
      "offset": 5
    }
  ],
  "location": "registerCarSteps.year(int)"
});
formatter.result({
  "duration": 50178,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "green",
      "offset": 19
    },
    {
      "val": "Subaru",
      "offset": 37
    }
  ],
  "location": "registerCarSteps.the_car_colour_is_model_is(String,String)"
});
formatter.result({
  "duration": 46273,
  "status": "passed"
});
formatter.match({
  "location": "registerCarSteps.the_car_is_registered()"
});
formatter.result({
  "duration": 27643,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2001",
      "offset": 29
    },
    {
      "val": "YTZ235",
      "offset": 50
    },
    {
      "val": "green",
      "offset": 67
    },
    {
      "val": "5",
      "offset": 78
    }
  ],
  "location": "registerCarSteps.the_car_s_attributes_of_year_license_plate_colour_and_seats_are_stored(int,String,String,int)"
});
formatter.result({
  "duration": 88939,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Jo registers 2 cars",
  "description": "",
  "id": "register-car;jo-registers-2-cars",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "Jo is a driver",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "Jo has a car registered a car",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "jo registers a new car",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "the car\u0027s is registered and jo has add the car to his account",
  "keyword": "Then "
});
formatter.match({
  "location": "registerCarSteps.jo_is_a_driver()"
});
formatter.result({
  "duration": 30348,
  "status": "passed"
});
formatter.match({
  "location": "registerCarSteps.jo_has_a_car_registered_a_car()"
});
formatter.result({
  "duration": 32752,
  "status": "passed"
});
formatter.match({
  "location": "registerCarSteps.jo_registers_a_new_car()"
});
formatter.result({
  "duration": 19530,
  "status": "passed"
});
formatter.match({
  "location": "registerCarSteps.the_car_s_is_registered_and_jo_has_add_the_car_to_his_account()"
});
formatter.result({
  "duration": 10817,
  "status": "passed"
});
formatter.uri("searchStopPoint.feature");
formatter.feature({
  "line": 1,
  "name": "Search stop point",
  "description": "As a user​, I want to search for existing stop points so that I can define or find rides",
  "id": "search-stop-point",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Search for stop points",
  "description": "",
  "id": "search-stop-point;search-for-stop-points",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "there is some stop points",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "when I search for a stop point buy entering \"Bear\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the search results should show 6 hare street as a result.",
  "keyword": "Then "
});
formatter.match({
  "location": "searchSteps.thereIsSomeStopPoints()"
});
formatter.result({
  "duration": 73014,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Bear",
      "offset": 45
    }
  ],
  "location": "searchSteps.whenISearchForAStopPointBuyEntering(String)"
});
formatter.result({
  "duration": 16668855,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 31
    }
  ],
  "location": "searchSteps.theSearchResultsShouldShowHareStreetAsAResult(int)"
});
formatter.result({
  "duration": 497277,
  "status": "passed"
});
formatter.uri("seeRideDetails.feature");
formatter.feature({
  "line": 1,
  "name": "See ride details",
  "description": "As ​​passenger​​, I want to ​​see the details of a specific ride so that I can choose the\r\nbest ride for me.",
  "id": "see-ride-details",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Sally sees details of a ride",
  "description": "",
  "id": "see-ride-details;sally-sees-details-of-a-ride",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Sally is a passenger",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "sally selects a ride which is from \"Jo\" who is \"gold\" grade and with a 1995 \"Green\" \"Subaru\" with 4 seats available",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "the route is 20 minutes long with 3 stops.",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "the rides details are displayed including drivers name, grade, car model, color, year, seats available, route length and number of stops.",
  "keyword": "Then "
});
formatter.match({
  "location": "rideDetailsSteps.sallyIsAPassenger()"
});
formatter.result({
  "duration": 18328,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Jo",
      "offset": 36
    },
    {
      "val": "gold",
      "offset": 48
    },
    {
      "val": "1995",
      "offset": 71
    },
    {
      "val": "Green",
      "offset": 77
    },
    {
      "val": "Subaru",
      "offset": 85
    },
    {
      "val": "4",
      "offset": 98
    }
  ],
  "location": "rideDetailsSteps.sallySelectsARideWhichIsFromWhoIsGradeAndWithAWithSeatsAvailable(String,String,int,String,String,int)"
});
formatter.result({
  "duration": 141221,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "20",
      "offset": 13
    },
    {
      "val": "3",
      "offset": 34
    }
  ],
  "location": "rideDetailsSteps.theRouteIsMinutesLongWithStops(int,int)"
});
formatter.result({
  "duration": 159550,
  "status": "passed"
});
formatter.match({
  "location": "rideDetailsSteps.theRidesDetailsAreDisplayedIncludingDriversNameGradeCarModelColorYearSeatsAvailableRouteLengthAndNumberOfStops()"
});
formatter.result({
  "duration": 1230685284,
  "status": "passed"
});
formatter.uri("seeRidesForStopPoint.feature");
formatter.feature({
  "line": 1,
  "name": "See rides for a stop point",
  "description": " As a ​​passenger​​, I want to ​​see the available rides at a specific stop point so that I\r\n can choose one.",
  "id": "see-rides-for-a-stop-point",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Sally wants to see rides to get home",
  "description": "",
  "id": "see-rides-for-a-stop-point;sally-wants-to-see-rides-to-get-home",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "there is some stop points including 6 \"Hare\" street.",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "sally is a passenger",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "there are some rides with 6 \"Hare\" street included as a stop point",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "sally selects a 6 \"Hare\" street",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the rides which have 6 \"Hare\" street as a stop point are seen.",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 36
    },
    {
      "val": "Hare",
      "offset": 39
    }
  ],
  "location": "seeRidesForStopPointSteps.thereIsSomeStopPointsIncludingStreet(int,String)"
});
formatter.result({
  "duration": 203418,
  "status": "passed"
});
formatter.match({
  "location": "seeRidesForStopPointSteps.sallyIsAPassenger()"
});
formatter.result({
  "duration": 14122,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 26
    },
    {
      "val": "Hare",
      "offset": 29
    }
  ],
  "location": "seeRidesForStopPointSteps.thereAreSomeRidesWithStreetIncludedAsAStopPoint(int,String)"
});
formatter.result({
  "duration": 299869,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 16
    },
    {
      "val": "Hare",
      "offset": 19
    }
  ],
  "location": "seeRidesForStopPointSteps.sallySelectsAStreet(int,String)"
});
formatter.result({
  "duration": 57389,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 21
    },
    {
      "val": "Hare",
      "offset": 24
    }
  ],
  "location": "seeRidesForStopPointSteps.theRidesWhichHaveStreetAsAStopPointAreSeen(int,String)"
});
formatter.result({
  "duration": 83230,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Sally wants to filter the rides",
  "description": "",
  "id": "see-rides-for-a-stop-point;sally-wants-to-filter-the-rides",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "there is a stop point that has multiple rides that go to it.",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "sally has selected that stop point",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "sally is a passenger",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "sally selects a filter option \"To university\"",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "the rides which go \"To university\" are seen.",
  "keyword": "Then "
});
formatter.match({
  "location": "seeRidesForStopPointSteps.thereIsAStopPointThatHasMultipleRidesThatGoToIt()"
});
formatter.result({
  "duration": 301071,
  "status": "passed"
});
formatter.match({
  "location": "seeRidesForStopPointSteps.sallyHasSelectedThatStopPoint()"
});
formatter.result({
  "duration": 43869,
  "status": "passed"
});
formatter.match({
  "location": "seeRidesForStopPointSteps.sallyIsAPassenger()"
});
formatter.result({
  "duration": 8113,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "To university",
      "offset": 31
    }
  ],
  "location": "seeRidesForStopPointSteps.sallySelectsAFilterOption(String)"
});
formatter.result({
  "duration": 35155,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "To university",
      "offset": 20
    }
  ],
  "location": "seeRidesForStopPointSteps.theRidesWhichGoAreSeen(String)"
});
formatter.result({
  "duration": 54986,
  "status": "passed"
});
formatter.uri("shareRide.feature");
formatter.feature({
  "line": 1,
  "name": "Share Ride",
  "description": "As a ​ driver​ , I want to ​ share a ride so that it can be displayed to potential passengers.",
  "id": "share-ride",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Jo shares a ride",
  "description": "",
  "id": "share-ride;jo-shares-a-ride",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Jo has made a trip",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "jo shares the trip with 3 available seats",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "a ride that can be booked is created and the trip is shared",
  "keyword": "Then "
});
formatter.match({
  "location": "shareRideSteps.joHasMadeATrip()"
});
formatter.result({
  "duration": 207925,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 24
    }
  ],
  "location": "shareRideSteps.joSharesTheTripWithAvailableSeats(int)"
});
formatter.result({
  "duration": 114179,
  "status": "passed"
});
formatter.match({
  "location": "shareRideSteps.aRideThatCanBeBookedIsCreatedAndTheTripIsShared()"
});
formatter.result({
  "duration": 23137,
  "status": "passed"
});
formatter.uri("storeData.feature");
formatter.feature({
  "line": 1,
  "name": "Store entered Data",
  "description": "As a ​​user​​, I want the system to ​​store my data​​, so I don’t have to re-enter it everytime I restart the\r\napplication.",
  "id": "store-entered-data",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Jo closes the application after entering some data",
  "description": "",
  "id": "store-entered-data;jo-closes-the-application-after-entering-some-data",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "there is a trip in the system",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "the application is closed",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "the trip is entered in the json",
  "keyword": "Then "
});
formatter.match({
  "location": "storeDataSteps.thereIsATripInTheSystem()"
});
formatter.result({
  "duration": 1370743,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.theApplicationIsClosed()"
});
formatter.result({
  "duration": 11969810,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.theTripIsEnteredInTheJson()"
});
formatter.result({
  "duration": 5139534,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Jo starts the application after entering some data",
  "description": "",
  "id": "store-entered-data;jo-starts-the-application-after-entering-some-data",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "there is a trip in the system",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "the application is reopened",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "the trip should still be there",
  "keyword": "Then "
});
formatter.match({
  "location": "storeDataSteps.thereIsATripInTheSystem()"
});
formatter.result({
  "duration": 283943,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.theApplicationIsReopened()"
});
formatter.result({
  "duration": 9465395,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.theTripShouldStillBeThere()"
});
formatter.result({
  "duration": 76320,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Jo closes the application after sharing a trip",
  "description": "",
  "id": "store-entered-data;jo-closes-the-application-after-sharing-a-trip",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "there is a trip in the system",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "there is a ride",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "the application is closed",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "the ride is in the json",
  "keyword": "Then "
});
formatter.match({
  "location": "storeDataSteps.thereIsATripInTheSystem()"
});
formatter.result({
  "duration": 174573,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.thereIsARide()"
});
formatter.result({
  "duration": 500883,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.theApplicationIsClosed()"
});
formatter.result({
  "duration": 18057326,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.theRideIsInTheJson()"
});
formatter.result({
  "duration": 625878,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Jo starts the application sharing a tip",
  "description": "",
  "id": "store-entered-data;jo-starts-the-application-sharing-a-tip",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "there is a trip in the system",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "there is a ride",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "the application is reopened",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "the ride should still be there",
  "keyword": "Then "
});
formatter.match({
  "location": "storeDataSteps.thereIsATripInTheSystem()"
});
formatter.result({
  "duration": 134611,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.thereIsARide()"
});
formatter.result({
  "duration": 656826,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.theApplicationIsReopened()"
});
formatter.result({
  "duration": 4077974,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.theRideShouldStillBeThere()"
});
formatter.result({
  "duration": 175474,
  "status": "passed"
});
});