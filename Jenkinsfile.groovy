UPSTREAM = URLEncoder.encode('sandbox/fclausen/jenkins-k8s-hello-world/master', "UTF-8")

properties([
  parameters([
    string(name: 'SOME_PARAM',
      defaultValue: "42",
      description: "Set to 1 to fix everything"
    ),
  ]),
  pipelineTriggers([
    upstream(UPSTREAM)
  ])
])

// URLEncoder.encode(toEncode, "UTF-8") 
echo "I have run with $env.SOME_PARAM"
