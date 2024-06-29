import caliban.*
import caliban.quick.*
import caliban.schema.ArgBuilder.auto.*
import caliban.schema.Schema.auto.*

@main def hello(): Unit =
  println(render[Query])

  val api = graphQL(RootResolver(queryResolver))
  api.unsafe.runServer(8088, "/api/graphql")

val sampleCharacters = List(
  Character("James Holden", List("Jim", "Hoss"), Origin.EARTH),
  Character("Naomi Nagata", Nil, Origin.BELT),
  Character("Amos Burton", Nil, Origin.EARTH),
  Character("Alex Kamal", Nil, Origin.MARS),
  Character("Chrisjen Avasarala", Nil, Origin.EARTH),
  Character("Josephus Miller", List("Joe"), Origin.BELT),
  Character("Roberta Draper", List("Bobbie", "Gunny"), Origin.MARS)
)

def charactersByOrigin(origin: Option[Origin]): List[Character] =
  sampleCharacters.filter(c => origin.forall(_ == c.origin))

def characterByName(name: String): Option[Character] =
  sampleCharacters.find(_.name == name)

val queryResolver =
  Query(
    characters = args => charactersByOrigin(args.origin),
    character = args => characterByName(args.name)
  )
