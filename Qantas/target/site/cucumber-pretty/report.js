$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("FrequentFlyer_Registration.feature");
formatter.feature({
  "line": 1,
  "name": "Qantas Frequent Flyer Registration form filling",
  "description": "",
  "id": "qantas-frequent-flyer-registration-form-filling",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3240341,
  "status": "passed"
});
formatter.before({
  "duration": 71273,
  "status": "passed"
});
formatter.before({
  "duration": 34154646864,
  "status": "passed"
});
formatter.scenario({
  "line": 2,
  "name": "User enter all the personal details on the frequent flyer page",
  "description": "",
  "id": "qantas-frequent-flyer-registration-form-filling;user-enter-all-the-personal-details-on-the-frequent-flyer-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "Qantas frequent flyer registration url",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "the form is ready for entering details",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "user enters the personal details",
  "rows": [
    {
      "cells": [
        "Title",
        "First_Name",
        "Last_Name",
        "Mobile_Number"
      ],
      "line": 6
    },
    {
      "cells": [
        "Mr",
        "Rajaneesh",
        "Balakrishnan",
        "0423149505"
      ],
      "line": 7
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user enters the address details",
  "rows": [
    {
      "cells": [
        "Address_Line1",
        "Address_Line2",
        "Suburb",
        "State",
        "PostalCode"
      ],
      "line": 9
    },
    {
      "cells": [
        "67",
        "Girraween_Road",
        "Girraween",
        "7",
        "2145"
      ],
      "line": 10
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user enters the email and consent",
  "rows": [
    {
      "cells": [
        "Email",
        "Email_Confirmation"
      ],
      "line": 12
    },
    {
      "cells": [
        "sydneyrajaneesh@gmail.com",
        "sydneyrajaneesh@gmail.com"
      ],
      "line": 13
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "the user enters the security information",
  "rows": [
    {
      "cells": [
        "Date",
        "Month",
        "Year",
        "Mothers_Maiden_name",
        "create_pin",
        "confirm_pin"
      ],
      "line": 15
    },
    {
      "cells": [
        "17",
        "3",
        "85",
        "Rajam",
        "9809",
        "9809"
      ],
      "line": 16
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "the user accepts the terms and conditions",
  "keyword": "Then "
});
formatter.match({
  "location": "Registration_FFlyer.qantas_frequent_flyer_registration_url()"
});
formatter.result({
  "duration": 5169061619,
  "status": "passed"
});
formatter.match({
  "location": "Registration_FFlyer.the_form_is_ready_for_entering_details()"
});
formatter.result({
  "duration": 455822920,
  "status": "passed"
});
formatter.match({
  "location": "Registration_FFlyer.user_enters_the_personal_details(DataTable)"
});
formatter.result({
  "duration": 8220934436,
  "status": "passed"
});
formatter.match({
  "location": "Registration_FFlyer.user_enters_the_address_details(DataTable)"
});
formatter.result({
  "duration": 3713548307,
  "status": "passed"
});
formatter.match({
  "location": "Registration_FFlyer.user_enters_the_email_and_consent(DataTable)"
});
formatter.result({
  "duration": 5465570740,
  "status": "passed"
});
formatter.match({
  "location": "Registration_FFlyer.the_user_enters_the_security_information(DataTable)"
});
formatter.result({
  "duration": 4120239841,
  "status": "passed"
});
formatter.match({
  "location": "Registration_FFlyer.the_user_accepts_the_terms_and_conditions()"
});
formatter.result({
  "duration": 76646247523,
  "status": "passed"
});
formatter.after({
  "duration": 11695087545,
  "status": "passed"
});
formatter.after({
  "duration": 108904,
  "status": "passed"
});
});