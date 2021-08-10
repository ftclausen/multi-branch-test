// If escaping:
// UPSTREAM = String.format( 'sandbox/fclausen/jenkins-k8s-hello-world/%s', URLEncoder.encode('compat/develop', "UTF-8") )

properties([
  parameters([
    string(name: 'SOME_PARAM',
      defaultValue: "42",
      description: "Set to 1 to fix everything"
    ),
  ]),
  pipelineTriggers([
    upstream('sandbox/fclausen/jenkins-k8s-hello-world/master')
  ])
])

// URLEncoder.encode(toEncode, "UTF-8")
echo "I have run with $env.SOME_PARAM"
