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
  "duration": 505429748,
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
  "duration": 37791968,
  "status": "passed"
});
formatter.match({
  "location": "addRouteSteps.joCreatesRouteByAddingStopPoints()"
});
formatter.result({
  "duration": 8195724,
  "status": "passed"
});
formatter.match({
  "location": "addRouteSteps.aNewRouteIsStoredWithTheStopPoints()"
});
formatter.result({
  "duration": 1138193,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Jo makes a route",
  "description": "",
  "id": "create-route;jo-makes-a-route",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "Jo is a driver and wants to make a route",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "jo creates route by with 0 stop points",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "a new route is not made and an exception is thrown.",
  "keyword": "Then "
});
formatter.match({
  "location": "addRouteSteps.joIsADriverAndWantsToMakeARoute()"
});
formatter.result({
  "duration": 93221,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 25
    }
  ],
  "location": "addRouteSteps.joCreatesRouteByWithStopPoints(int)"
});
formatter.result({
  "duration": 99401,
  "status": "passed"
});
formatter.match({
  "location": "addRouteSteps.aNewRouteIsNotMadeAndAnExceptionIsThrown()"
});
formatter.result({
  "duration": 67087,
  "status": "passed"
});
formatter.uri("addTrip.feature");
formatter.feature({
  "line": 1,
  "name": "make trip",
  "description": "As ​​driver​​, I want to ​​add trips so that I can set up all the information for the rides\nthat I will share later on",
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
  "name": "Jo creates a recurrent is \"true\" trip by defining it to be his only route \"to university\" 1500 each stop point 15 minutes after the previous",
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
  "duration": 56791,
  "status": "passed"
});
formatter.match({
  "location": "makeTripSteps.joHasSomeRoutes()"
});
formatter.result({
  "duration": 202732,
  "status": "passed"
});
formatter.match({
  "location": "makeTripSteps.joRegisteredACar()"
});
formatter.result({
  "duration": 38595750,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "true",
      "offset": 27
    },
    {
      "val": "to university",
      "offset": 75
    },
    {
      "val": "1500",
      "offset": 90
    },
    {
      "val": "15",
      "offset": 111
    }
  ],
  "location": "makeTripSteps.joCreatesARecurrentIsTripByDefiningItToBeHisOnlyRouteEachStopPointMinutesAfterThePrevious(String,String,int,int)"
});
formatter.result({
  "duration": 18473621,
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
  "duration": 858722,
  "status": "passed"
});
formatter.match({
  "location": "makeTripSteps.theTripIsDisplayedToJoWithAllInformation()"
});
formatter.result({
  "duration": 76601,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Jo makes a trip",
  "description": "",
  "id": "make-trip;jo-makes-a-trip",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "jo is a driver making a trip",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "jo has some routes",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "Jo registered a car.",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Jo creates a recurrent is \"false\" trip by defining it to be his only route \"to university\" 1500 each stop point 15 minutes after the previous",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "it is added to jo",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "the no recurrent trip is displayed to jo with all information.",
  "keyword": "Then "
});
formatter.match({
  "location": "makeTripSteps.joIsADriverMakingATrip()"
});
formatter.result({
  "duration": 22371,
  "status": "passed"
});
formatter.match({
  "location": "makeTripSteps.joHasSomeRoutes()"
});
formatter.result({
  "duration": 121888,
  "status": "passed"
});
formatter.match({
  "location": "makeTripSteps.joRegisteredACar()"
});
formatter.result({
  "duration": 51530,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "false",
      "offset": 27
    },
    {
      "val": "to university",
      "offset": 76
    },
    {
      "val": "1500",
      "offset": 91
    },
    {
      "val": "15",
      "offset": 112
    }
  ],
  "location": "makeTripSteps.joCreatesARecurrentIsTripByDefiningItToBeHisOnlyRouteEachStopPointMinutesAfterThePrevious(String,String,int,int)"
});
formatter.result({
  "duration": 187391,
  "status": "passed"
});
formatter.match({
  "location": "makeTripSteps.itIsAddedToJo()"
});
formatter.result({
  "duration": 20413,
  "status": "passed"
});
formatter.match({
  "location": "makeTripSteps.theNoRecurrentTripIsDisplayedToJoWithAllInformation()"
});
formatter.result({
  "duration": 21748,
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
  "duration": 54138,
  "status": "passed"
});
formatter.match({
  "location": "bookRideSteps.sallyHasSelectedARide()"
});
formatter.result({
  "duration": 62929642,
  "status": "passed"
});
formatter.match({
  "location": "bookRideSteps.sallyBooksTheRide()"
});
formatter.result({
  "duration": 88592,
  "status": "passed"
});
formatter.match({
  "location": "bookRideSteps.sallyWillBeExpectedOnTheRideAndTheAvailableSeatsDecreases()"
});
formatter.result({
  "duration": 70124,
  "status": "passed"
});
formatter.match({
  "location": "bookRideSteps.sheWillKnowThatSheBookedTheRide()"
});
formatter.result({
  "duration": 18133,
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
  "duration": 33736,
  "status": "passed"
});
formatter.match({
  "location": "bookRideSteps.sallyHasBookedARide()"
});
formatter.result({
  "duration": 106984,
  "status": "passed"
});
formatter.match({
  "location": "bookRideSteps.sallyGoesToBookTheRideAgain()"
});
formatter.result({
  "duration": 19204,
  "status": "passed"
});
formatter.match({
  "location": "bookRideSteps.nothingHappensAndSheIsNotIncludedAgain()"
});
formatter.result({
  "duration": 26440,
  "status": "passed"
});
formatter.uri("cancelBooking.feature");
formatter.feature({
  "line": 1,
  "name": "Cancel booking",
  "description": "As a ​​passenger​​, I want to ​​cancel a booked ride so that the driver will be informed and the seat\ncan be used by someone else.",
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
  "duration": 259746,
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
  "duration": 116987,
  "status": "passed"
});
formatter.match({
  "location": "cancelBookedRideSteps.theDriversCarIsAvailableAgainIfItWasnTBeforeWithUpdatedAvailableSeats()"
});
formatter.result({
  "duration": 50513,
  "status": "passed"
});
formatter.match({
  "location": "cancelBookedRideSteps.theDriverIsNotifiedOfTheCancellation()"
});
formatter.result({
  "duration": 142888,
  "status": "passed"
});
formatter.uri("cancelRide.feature");
formatter.feature({
  "line": 1,
  "name": "Cancel Ride",
  "description": "As a ​​driver​​, I want to ​​cancel a ride so the passengers will be notified that I will no longer be\npicking them up",
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
  "duration": 87765,
  "status": "passed"
});
formatter.match({
  "location": "cancelRideSteps.joHasATripWhichHeHasShared()"
});
formatter.result({
  "duration": 454529,
  "status": "passed"
});
formatter.match({
  "location": "cancelRideSteps.thereArePassengersBookedOnTheRide()"
});
formatter.result({
  "duration": 55191,
  "status": "passed"
});
formatter.match({
  "location": "cancelRideSteps.joSelectsToCancelTheRide()"
});
formatter.result({
  "duration": 36937,
  "status": "passed"
});
formatter.match({
  "location": "cancelRideSteps.thePassengersAreNotified()"
});
formatter.result({
  "duration": 39867,
  "status": "passed"
});
formatter.match({
  "location": "cancelRideSteps.theRideIsNoLongerAvailable()"
});
formatter.result({
  "duration": 30863,
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
  "duration": 76445,
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
  "duration": 164333,
  "status": "passed"
});
formatter.match({
  "location": "createAccountSteps.theEmailAndPasswordAreVerifiedAndHeIsAskedForHisDriversLicenseInformation()"
});
formatter.result({
  "duration": 544635,
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
  "duration": 7591967,
  "status": "passed"
});
formatter.match({
  "location": "createAccountSteps.itIsVerifiedHeCanCarryPassengers()"
});
formatter.result({
  "duration": 91632,
  "status": "passed"
});
formatter.match({
  "location": "createAccountSteps.hisDetailsAreStoredAndAccountIsCreated()"
});
formatter.result({
  "duration": 171652126,
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
  "duration": 43304,
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
  "duration": 102165,
  "status": "passed"
});
formatter.match({
  "location": "createAccountSteps.theEmailAndPasswordAreVerifiedAndHerAccountIsCreated()"
});
formatter.result({
  "duration": 33928707,
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
  "duration": 61020,
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
  "duration": 70485,
  "status": "passed"
});
formatter.match({
  "location": "createAccountSteps.theEmailFailsVerificationAndSheIsToldTheEmailIsAlreadyInUse()"
});
formatter.result({
  "duration": 17688868,
  "status": "passed"
});
formatter.uri("createStopPoints.feature");
formatter.feature({
  "line": 1,
  "name": "create stop points",
  "description": "As ​​driver​​, I want to ​​create stop points so I can specify where I will pick up or drop\noff passengers",
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
  "duration": 93844,
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
  "duration": 955896,
  "status": "passed"
});
formatter.match({
  "location": "createStopPointSteps.the_street_address_is_stored_as_a_stop_point()"
});
formatter.result({
  "duration": 71681,
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
  "duration": 50051,
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
  "duration": 116802,
  "status": "passed"
});
formatter.match({
  "location": "createStopPointSteps.a_new_stop_point_is_not_made()"
});
formatter.result({
  "duration": 19540,
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
  "duration": 87966,
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
  "duration": 98968,
  "status": "passed"
});
formatter.match({
  "location": "editAccountSteps.herDetailsAreChanged()"
});
formatter.result({
  "duration": 48887,
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
  "duration": 32993,
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
  "duration": 84716,
  "status": "passed"
});
formatter.match({
  "location": "editAccountSteps.herDetailsAreNotChanged()"
});
formatter.result({
  "duration": 24377,
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
  "duration": 73649,
  "status": "passed"
});
formatter.match({
  "location": "editAccountSteps.joGoesToEditHisAccountAndChangesHisLicenseExpirationToNextYear()"
});
formatter.result({
  "duration": 23630,
  "status": "passed"
});
formatter.match({
  "location": "editAccountSteps.hisNewLicenseInformationIsStored()"
});
formatter.result({
  "duration": 30484,
  "status": "passed"
});
formatter.uri("expirationNotification.feature");
formatter.feature({
  "line": 1,
  "name": "Notify User of expiration",
  "description": "As a ​​driver​​, I want to be ​​notified ​​if my drivers licence, WOF or registration is about to expire so I\ncan renew them on time.",
  "id": "notify-user-of-expiration",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "license expires in one month",
  "description": "",
  "id": "notify-user-of-expiration;license-expires-in-one-month",
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
  "duration": 65304,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.hisLicenseExpiresInOneMonth()"
});
formatter.result({
  "duration": 90132,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.logsIn()"
});
formatter.result({
  "duration": 21684,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.heWillBeNotifiedThatHisLicenseGoingToExpire()"
});
formatter.result({
  "duration": 185193,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "WOF expires in one month",
  "description": "",
  "id": "notify-user-of-expiration;wof-expires-in-one-month",
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
  "duration": 31606,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.hisWOFExpiresInOneMonth()"
});
formatter.result({
  "duration": 108000,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.logsIn()"
});
formatter.result({
  "duration": 12963,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.heWillBeNotifiedThatSWOFIsGoingToExpire()"
});
formatter.result({
  "duration": 233133,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "registration and licence expires in one month",
  "description": "",
  "id": "notify-user-of-expiration;registration-and-licence-expires-in-one-month",
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
  "duration": 38176,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.hisRegistrationExpiresInOneMonth()"
});
formatter.result({
  "duration": 110290,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.hisLicenseExpiresInOneMonth()"
});
formatter.result({
  "duration": 55035,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.logsIn()"
});
formatter.result({
  "duration": 13287,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.heWillBeNotifiedThatTheRegistrationAndLicenseAreGoingToExpire()"
});
formatter.result({
  "duration": 151616,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "licence expires in 3 weeks",
  "description": "",
  "id": "notify-user-of-expiration;licence-expires-in-3-weeks",
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
  "duration": 40837,
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
  "duration": 160768,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.logsIn()"
});
formatter.result({
  "duration": 16670,
  "status": "passed"
});
formatter.match({
  "location": "NotifyUserExpirationSteps.heWillNotBeNotifiedThatItIsGoingToExpire()"
});
formatter.result({
  "duration": 196467,
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
  "duration": 29538702,
  "status": "passed"
});
formatter.match({
  "location": "loginSteps.heEntersTheCorrectEmailAndPassword()"
});
formatter.result({
  "duration": 30494,
  "status": "passed"
});
formatter.match({
  "location": "loginSteps.heIsLetIntoHisAccountWithHisTripsEtc()"
});
formatter.result({
  "duration": 30491940,
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
  "duration": 28282091,
  "status": "passed"
});
formatter.match({
  "location": "loginSteps.joTriesToLogIn()"
});
formatter.result({
  "duration": 23310,
  "status": "passed"
});
formatter.match({
  "location": "loginSteps.heIsToldTheCredentialsAreWrong()"
});
formatter.result({
  "duration": 40989740,
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
  "duration": 57473,
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
  "duration": 61141,
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
  "duration": 27469,
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
  "duration": 32123,
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
  "duration": 37010,
  "status": "passed"
});
formatter.match({
  "location": "registerCarSteps.the_car_is_registered()"
});
formatter.result({
  "duration": 26553,
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
  "duration": 137923,
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
  "duration": 29241,
  "status": "passed"
});
formatter.match({
  "location": "registerCarSteps.jo_has_a_car_registered_a_car()"
});
formatter.result({
  "duration": 53412,
  "status": "passed"
});
formatter.match({
  "location": "registerCarSteps.jo_registers_a_new_car()"
});
formatter.result({
  "duration": 29513,
  "status": "passed"
});
formatter.match({
  "location": "registerCarSteps.the_car_s_is_registered_and_jo_has_add_the_car_to_his_account()"
});
formatter.result({
  "duration": 13625,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Jo registers car with no seats or year that doesn\u0027t exist",
  "description": "",
  "id": "register-car;jo-registers-car-with-no-seats-or-year-that-doesn\u0027t-exist",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "Jo is a driver",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "jo registers a \"car\" with 0 seats and license plate of \"123TRE\" and year -2000 and the colour is \"blue\"and the model is \"holden\"",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "the car is not made and exception is thrown",
  "keyword": "Then "
});
formatter.match({
  "location": "registerCarSteps.jo_is_a_driver()"
});
formatter.result({
  "duration": 26693,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "car",
      "offset": 16
    },
    {
      "val": "0",
      "offset": 26
    },
    {
      "val": "123TRE",
      "offset": 56
    },
    {
      "val": "2000",
      "offset": 74
    },
    {
      "val": "blue",
      "offset": 98
    },
    {
      "val": "holden",
      "offset": 121
    }
  ],
  "location": "registerCarSteps.joRegistersAWithSeatsAndLicensePlateOfTREAndYearAndTheColourIsAndTheModelIs(String,int,String,int,String,String)"
});
formatter.result({
  "duration": 132585,
  "status": "passed"
});
formatter.match({
  "location": "registerCarSteps.theCarIsNotMadeAndExceptionIsThrown()"
});
formatter.result({
  "duration": 49446,
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
  "name": "the search results should not show 6 hare street as a result.",
  "keyword": "Then "
});
formatter.match({
  "location": "searchSteps.thereIsSomeStopPoints()"
});
formatter.result({
  "duration": 110709,
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
  "duration": 17184555,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 35
    }
  ],
  "location": "searchSteps.theSearchResultsShouldNotShowHareStreetAsAResult(int)"
});
formatter.result({
  "duration": 641056,
  "status": "passed"
});
formatter.uri("seeRideDetails.feature");
formatter.feature({
  "line": 1,
  "name": "See ride details",
  "description": "As ​​passenger​​, I want to ​​see the details of a specific ride so that I can choose the\nbest ride for me.",
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
  "duration": 35728,
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
  "duration": 166500,
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
  "duration": 181153,
  "status": "passed"
});
formatter.match({
  "location": "rideDetailsSteps.theRidesDetailsAreDisplayedIncludingDriversNameGradeCarModelColorYearSeatsAvailableRouteLengthAndNumberOfStops()"
});
formatter.result({
  "duration": 575204672,
  "status": "passed"
});
formatter.uri("seeRidesForStopPoint.feature");
formatter.feature({
  "line": 1,
  "name": "See rides for a stop point",
  "description": " As a ​​passenger​​, I want to ​​see the available rides at a specific stop point so that I\n can choose one.",
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
  "duration": 142404,
  "status": "passed"
});
formatter.match({
  "location": "seeRidesForStopPointSteps.sallyIsAPassenger()"
});
formatter.result({
  "duration": 14643,
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
  "duration": 323909,
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
  "duration": 50790,
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
  "duration": 98052,
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
  "duration": 285990,
  "status": "passed"
});
formatter.match({
  "location": "seeRidesForStopPointSteps.sallyHasSelectedThatStopPoint()"
});
formatter.result({
  "duration": 42698,
  "status": "passed"
});
formatter.match({
  "location": "seeRidesForStopPointSteps.sallyIsAPassenger()"
});
formatter.result({
  "duration": 6575,
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
  "duration": 27330,
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
  "duration": 40956,
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
  "duration": 250036,
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
  "duration": 192140,
  "status": "passed"
});
formatter.match({
  "location": "shareRideSteps.aRideThatCanBeBookedIsCreatedAndTheTripIsShared()"
});
formatter.result({
  "duration": 28750,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Jo shares a ride",
  "description": "",
  "id": "share-ride;jo-shares-a-ride",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "Jo has made a trip",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "jo shares the trip with 13 available seats",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "a ride that can be booked is created with the maximum number of seats in the car",
  "keyword": "Then "
});
formatter.match({
  "location": "shareRideSteps.joHasMadeATrip()"
});
formatter.result({
  "duration": 141772,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "13",
      "offset": 24
    }
  ],
  "location": "shareRideSteps.joSharesTheTripWithAvailableSeats(int)"
});
formatter.result({
  "duration": 131980,
  "status": "passed"
});
formatter.match({
  "location": "shareRideSteps.aRideThatCanBeBookedIsCreatedWithTheMaximumNumberOfSeatsInTheCar()"
});
formatter.result({
  "duration": 38841,
  "status": "passed"
});
formatter.uri("storeData.feature");
formatter.feature({
  "line": 1,
  "name": "Store entered Data",
  "description": "As a ​​user​​, I want the system to ​​store my data​​, so I don’t have to re-enter it everytime I restart the\napplication.",
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
  "duration": 1240678,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.theApplicationIsClosed()"
});
formatter.result({
  "duration": 18564305,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.theTripIsEnteredInTheJson()"
});
formatter.result({
  "duration": 4899210,
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
  "duration": 403404,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.theApplicationIsReopened()"
});
formatter.result({
  "duration": 11058691,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.theTripShouldStillBeThere()"
});
formatter.result({
  "duration": 82293,
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
  "duration": 145255,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.thereIsARide()"
});
formatter.result({
  "duration": 587125,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.theApplicationIsClosed()"
});
formatter.result({
  "duration": 21110157,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.theRideIsInTheJson()"
});
formatter.result({
  "duration": 1335375,
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
  "duration": 951454,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.thereIsARide()"
});
formatter.result({
  "duration": 645720,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.theApplicationIsReopened()"
});
formatter.result({
  "duration": 9879340,
  "status": "passed"
});
formatter.match({
  "location": "storeDataSteps.theRideShouldStillBeThere()"
});
formatter.result({
  "duration": 217069,
  "status": "passed"
});
});