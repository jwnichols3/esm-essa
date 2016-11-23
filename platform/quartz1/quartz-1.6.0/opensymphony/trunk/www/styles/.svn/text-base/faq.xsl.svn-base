<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
        <xsl:template name="toc">
                <ol>
		<xsl:for-each select="/list/faq">
                        <li>
                                <a>
               				<xsl:attribute name="href">#<xsl:value-of select="position()" /></xsl:attribute>
                                        <xsl:value-of select="@question" />
                                </a>
                        </li>
		</xsl:for-each>
                </ol>
        </xsl:template>        
        
        <xsl:template name="contents">
                <ol>
		<xsl:for-each select="/list/faq">
                        <li>
                                <a>
               				<xsl:attribute name="name">
        					<xsl:value-of select="position()" />
        				</xsl:attribute>
                                        <xsl:value-of select="@question" />
                                </a>
                                <p>
                                        <xsl:apply-templates />
                                </p>
                        </li>
		</xsl:for-each>
                </ol>
        </xsl:template>
                
	<xsl:template match="/">
                <h3>Table of Contents</h3>
                <xsl:call-template name="toc" />
                <h3>The Answers</h3>
                <xsl:call-template name="contents" />
	</xsl:template>

	<xsl:template match="node()|@*"> 
	<xsl:copy> 
	<xsl:apply-templates select='@*|node()'/> 
	</xsl:copy> 
	</xsl:template> 
	
					
</xsl:stylesheet>
