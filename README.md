## sbt graphql caliban project compiled with Scala 3

### Usage

This is a normal sbt project. You can compile code with `sbt compile`, run it with `sbt run`, and `sbt console` will start a Scala 3 REPL.

We can make simple GraphQL request to `http://localhost:8088/api/graphql` after `sbt run`:
```shell
curl --request POST \
  --url http://localhost:8088/api/graphql/ \
  --header 'Content-Type: application/json' \
  --data '{"query":"query CharactersByOrigin($origin: Origin!) {\n\tcharacters(origin: $origin) {\n\t\tname\n\t\tnicknames\n\t\torigin\n\t}\n}\n","operationName":"CharactersByOrigin","variables":"{\n\t\"origin\": \"MARS\"\n}"}'
```