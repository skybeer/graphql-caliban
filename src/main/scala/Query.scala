final case class Query(
  characters: Query.CharactersArgs => List[Character],
  character: Query.CharacterArgs => Option[Character]
)

object Query {
  final case class CharactersArgs(origin: Option[Origin])
  final case class CharacterArgs(name: String)
}
