<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/twitch">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/twitch/viewers">
        <table border="1">
            <tr><td>Email</td><td>Passowrd</td><td>Nickname</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/twitch/viewers/viewer">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/twitch/viewers/viewer/email">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>

    <xsl:template match="/twitch/viewers/viewer/password">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>

    <xsl:template match="/twitch/viewers/viewer/nickname">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>


    <xsl:template match="/twitch/viewers/viewer/following">
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="/twitch/viewers/viewer/following/channelname">
    </xsl:template>

    <xsl:template match="/twitch/streamers">
        <table border="1">
            <tr><td>Email</td><td>Passowrd</td><td>Channelname</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/twitch/streamers/streamer">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/twitch/streamers/streamer/email">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>

    <xsl:template match="/twitch/streamers/streamer/password">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>

    <xsl:template match="/twitch/streamers/streamer/channelname">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>


    <xsl:template match="/twitch/streamers/streamer/followers">
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="/twitch/streamers/streamer/followers/nickname">
    </xsl:template>


</xsl:stylesheet>