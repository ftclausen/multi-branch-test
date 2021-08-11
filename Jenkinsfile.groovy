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
    upstream( "sandbox/fclausen/jenkins-k8s-hello-world/${URLEncoder.encode( env.BRANCH_NAME, 'UTF-8')}" ),
  ])
])

def cause = currentBuild.getBuildCauses('hudson.model.Cause$UpstreamCause')
if ( cause ) {
  echo "We have a cause!"
  def remoteBranch = cause.upstreamRun().getEnvironment()
  echo "Remove branch: $remoteBranch"
}

echo "Waits on: sandbox/fclausen/jenkins-k8s-hello-world/${URLEncoder.encode( env.BRANCH_NAME, 'UTF-8')}"
// URLEncoder.encode(toEncode, "UTF-8")
echo "I have run with $env.SOME_PARAM"
