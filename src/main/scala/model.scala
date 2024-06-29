enum Origin {
  case EARTH, MARS, BELT
}

case class Character(
  name: String,
  nicknames: List[String],
  origin: Origin
)
