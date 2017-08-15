<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- Edited with XML Spy v2007 (http://www.altova.com) -->
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method='xml' cdata-section-elements="title" version='1.0' encoding='UTF-8' indent='yes'/>

<xsl:template match="/">
<cds>
      <xsl:for-each select="catalog/cd">
	  <cd>
        <title><xsl:value-of select="title" disable-output-escaping="no"/></title>
        <artist><xsl:value-of select="artist"/></artist>
		<tp><xsl:value-of select="tp"/></tp>
		</cd>
      </xsl:for-each>
  </cds>
</xsl:template>
</xsl:stylesheet>