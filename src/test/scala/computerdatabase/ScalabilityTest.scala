package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

class ScalabilityTest extends Simulation {
  val basicSimulation_val = new BasicSimulation

  setUp(
    basicSimulation_val.scn.inject(rampUsersPerSec(0.01) to (1.2) during (2 minute), constantUsersPerSec(1.2) during (4 minute))
  ).protocols(basicSimulation_val.httpProtocol)
}
