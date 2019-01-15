<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/buyers">
        <table  border="2" bordercolor="#d3d3d3" cellspacing="2" width="800">
            <tr bgcolor="lightblue"><td>Full Name</td><td>E-mail</td><td>Username</td><td>Password</td><td>Phone</td></tr>


            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/buyers/buyer">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match="/buyers/buyer/fullname">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/buyers/buyer/email">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/buyers/buyer/username">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/buyers/buyer/password">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/buyers/buyer/phone">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/buyers/buyer/purchases">
        <table  border="2" bordercolor="#d3d3d3" cellspacing="2"  width="800">
            <tr bgcolor="lightgreen"><td>Item</td><td>Item ID</td><td>Color</td><td>Price</td><td>Shipping Address</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/buyers/buyer/purchases/purchase">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/buyers/buyer/purchases/purchase/item">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/buyers/buyer/purchases/purchase/item_id">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/buyers/buyer/purchases/purchase/color">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/buyers/buyer/purchases/purchase/price">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/buyers/buyer/purchases/purchase/shipping_address">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

</xsl:stylesheet>