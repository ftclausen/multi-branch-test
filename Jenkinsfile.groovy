@Library( 'bb-common@1.x' ) _

properties([
  parameters([
    string(name: 'SOME_PARAM',
      defaultValue: "42",
      description: "Set to 1 to fix everything"
    ),
  ])
])

bb.pod.create(
  label: 'fclausen-mbptest',
) {
    stage('Run shell') {
      checkout scm
      sh 'echo "hello world"'
    }
}
