<?xml version="1.0" encoding="UNICODE"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/persons">
        <table border="1">
            <tr>
                <td>Name</td>
                <td>Login</td>
                <td>Password</td>
                <td>DateOfBirth</td>
                <td>Email</td>
                <td>Tel</td>
                <td>Privelegy</td>
                <td>Ads</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/persons/user">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/persons/user/name">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/persons/user/login">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/persons/user/password">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/persons/user/dateOfBirth">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/persons/user/email">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/persons/user/tel">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/persons/user/privelegy">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/persons/user/ads/ad">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/persons/admin">
        <table border="1">
            <tr>
                <td>
                    <xsl:apply-templates/>
                </td>
            </tr>
        </table>
    </xsl:template>

    <xsl:template match="/persons/admin/login">
        <td>
            <xsl:apply-templates/>

        </td>
    </xsl:template>

    <xsl:template match="/persons/admin/password">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/persons/admin/privelegy">
        <td></td>
        <td></td>
        <td></td>
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/persons/guest">
        <table border="1">
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>
                    <xsl:apply-templates/>
                </td>

            </tr>
        </table>
    </xsl:template>

    <xsl:template match="/persons/guest/privelegy">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

</xsl:stylesheet>