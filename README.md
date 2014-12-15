# Ssese, a Clojure Server-Sent Events (SSE) Client

Ssese is a Clojure server-sent events client built around Netty 5.


## Project Goals

 * Provide a sensible public API.
 * Have integration test coverage.
 * Target Netty 5.
 * Be well documented


## Project Maturity

Ssese is *very* young.


## Artifacts

Ssese artifacts are [released to Clojars](https://clojars.org/clojurewerkz/ssese). If you are using Maven, add the following repository
definition to your `pom.xml`:

``` xml
<repository>
  <id>clojars.org</id>
  <url>http://clojars.org/repo</url>
</repository>
```

### The Most Recent Release

With Leiningen:

    [clojurewerkz/ssese "1.0.0-SNAPSHOT"]


With Maven:

    <dependency>
      <groupId>clojurewerkz</groupId>
      <artifactId>ssese</artifactId>
      <version>1.0.0-SNAPSHOT</version>
    </dependency>


## Documentation & Examples

The project is too young to begin documenting the API.

This section will be updated when the API stabilizes.


## Community & Support

To subscribe for announcements of releases, important changes and so on,
please follow [@ClojureWerkz](https://twitter.com/clojurewerkz) on Twitter.


## Supported Clojure versions

Ssese is built from the ground up for Clojure 1.6.0+.


## Continuous Integration Status

[![Continuous Integration status](https://secure.travis-ci.org/clojurewerkz/ssese.png)](http://travis-ci.org/clojurewerkz/ssese)


## Ssese Is a ClojureWerkz Project

ssese is part of the [group of Clojure libraries known as ClojureWerkz](http://clojurewerkz.org), together with

 * [Monger](http://clojuremongodb.info)
 * [Langohr](http://clojurerabbitmq.info)
 * [Elastisch](http://clojureelasticsearch.info)
 * [Cassaforte](http://clojurecassandra.info)
 * [Titanium](http://titanium.clojurewerkz.org)
 * [Neocons](http://clojureneo4j.info)
 * [EEP](https://github.com/clojurewerkz/eep)

and several others.


## Development

Ssese uses [Leiningen 2](https://github.com/technomancy/leiningen/blob/master/doc/TUTORIAL.md). Make
sure you have it installed and then run tests against supported
Clojure versions using

    lein all test

Then create a branch and make your changes on it. Once you are done
with your changes and all tests pass, submit a pull request on GitHub.



## License

Copyright (C) 2014 Michael S. Klishin, Alex Petrov, and The ClojureWerkz Team.

Double licensed under the [Eclipse Public License](http://www.eclipse.org/legal/epl-v10.html) (the same as Clojure) or
the [Apache Public License 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).
