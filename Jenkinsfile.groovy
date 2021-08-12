// If escaping:
// UPSTREAM = String.format( 'sandbox/fclausen/jenkins-k8s-hello-world/%s', URLEncoder.encode('compat/develop', "UTF-8") )

properties([
  parameters([
    string(name: 'SOME_PARAM',
      defaultValue: "42",
      description: "Set to 1 to fix everything"
    ),
  ]),
  pipelineTriggers( [
    upstream( getParentBranches( 'sandbox/fclausen/jenkins-k8s-hello-world' ) ),
  ] ),
])

stage( 'Stuff' ) {
  def cause = currentBuild.rawBuild.getCause(hudson.model.Cause.UpstreamCause)
  if ( cause ) {
    echo "We have a cause!"
    def remoteBranch = cause.getUpstreamRun().getEnvironment().BRANCH_NAME
    echo "Remote branch: $remoteBranch"
  }
}

def getParentBranches( def jobName ) {
  def jobs = [ "$jobName/${URLEncoder.encode( env.BRANCH_NAME, 'UTF-8' )}" ]

  if ( env.BRANCH_NAME == 'develop' ) {
    jobs += "$jobName/${URLEncoder.encode( 'preDevelop/*', 'UTF-8' )}"
  }

  return jobs.join(",")
}
