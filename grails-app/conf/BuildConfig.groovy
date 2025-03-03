/*
 * Copyright © 2010 MBTE Sweden AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir	= "target/test-reports"
grails.project.dependency.resolution = {
    inherits 'global'
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {        
        mavenCentral()
        grailsPlugins() 
        grailsHome() 
        grailsCentral() 
    }
    dependencies {
        def cometdVer = '2.3.1'
        compile(group: 'org.cometd.java', name: 'cometd-java-server', version: cometdVer) {
            excludes 'servlet-api'
        }
        compile group: 'org.cometd.java', name: 'bayeux-api', version: cometdVer
        runtime group: 'org.eclipse.jetty', name: 'jetty-servlets', version: '7.4.4.v20110707'
        test group: 'org.cometd.java', name: 'cometd-java-client', version: cometdVer
    }
}
