properties([
  parameters([
    string(name: 'SOME_PARAM',
      defaultValue: "42",
      description: "Set to 1 to fix everything"
    ),
  ])
])

node('master') {
  sh 'echo "Hello world, lucky number $RANDOM"'
}
