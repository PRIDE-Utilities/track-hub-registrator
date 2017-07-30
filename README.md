ENSEMBL TrackHub Register
-------------------------

## ENSEMBL TrackHub Register Tool

This Java Tool enables users to publish their TrackHub into [ENSEMBL Registry](https://www.trackhubregistry.org/)
from commandline tool. Also, the tool provides a Java Library to interact with ENSEMBL Trackhub registry including functions for:
   - [Create a TrackHub in ENSEMBL](https://www.trackhubregistry.org/docs/api/registration/workflow/thregister)
   - [Update a TrackHub in ENSEMBL](https://www.trackhubregistry.org/docs/api/registration/workflow/thupdate)
   - [List all TrackHubs](https://www.trackhubregistry.org/docs/api/registration/workflow/thlist)

An introduction to ENSEMBL TrackHub Registry can be found [Here](https://www.trackhubregistry.org/)

## Commandline Tool Parameters

- A user (**user**) and password (**password**) should be provided to the tool. The user and password are provided
by ENSEMBL [TrackHub Registration Page](https://www.trackhubregistry.org/user/register).

### ENSEMBL TrackHub Properties

- TrackHub URL (**url**): is a public url of the TrackHub using the structure of [ENSEMBL/UCSC TrackHub definition](https://genome.ucsc.edu/goldenpath/help/hgTrackHubHelp.html#Intro). Example of a public TrackHub can be found here: http://ftp.pride.ebi.ac.uk/pride/data/proteogenomics/latest/proteoannotator/trackhub/homo_sapiens/hub.txt

- TRACK TYPE (**track_type**): The track hub type can be (PROTEOMICS, GENOMICS, EPIGENOMICS, TRANSCRIPTOMICS

- TrackHub Visibility (**visibility**): Visibility of the track, it can be values 1 (public) or 0 (private).

- TrackHub Assemblies (**assembly**): Map of key-value pairs assembly (e.g. -assembly hg38=GCA_000001405.15 ricCom1=GCA_000151685.2)


### File parameters input (JSON)

The trackhub information can be provided as JSON parameters file:

Example:

```json

{
   "url": "http://ftp.pride.ebi.ac.uk/pride/data/proteogenomics/latest/proteoannotator/trackhub/homo_sapiens/hub.txt",
   "public":"1",
   "type":"PROTEOMICS"
}

```

## Using the Library

Maven Dependency:

~~~~
    <dependencies>
      <dependency>
        <groupId>uk.ac.ebi.pride.utilities</groupId>
        <artifactId>track-hub-register</artifactId>
        <version>XXX</version>
      </dependency>
    </dependencies>
~~~~
~~~~
    <repositories>
      <!-- EBI repo -->
      <repository>
        <id>nexus-ebi-release-repo</id>
        <url>http://www.ebi.ac.uk/Tools/maven/repos/content/groups/ebi-repo/</url>
      </repository>
    </repositories>
~~~~

> Update the version number (XXX) to latest released version.

