<?xml version='1.0' ?>
<!-- Date: 10 July 2016-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:uml="http://schema.omg.org/spec/UML/2.0" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
	<xsl:output method="xml" indent="yes" encoding = "UTF-8"/>

	<xsl:variable name="ProfilePrefix">
		<xsl:text>MusicProfile__:MusicProfile__</xsl:text>
	</xsl:variable>

	<xsl:variable name="ProfileID">
		<xsl:text>_iXAad4PGEduaib1rbQg5jQ</xsl:text>
	</xsl:variable>

	<xsl:variable name="ProfileFile">
		<xsl:text>MusicProfile.profile.uml#_iXAZcIPGEduaib1rbQg5jQ</xsl:text>
	</xsl:variable>
	




	<xsl:variable name="intTypeID">
		<xsl:text>_iXAad4PGEduaib1rbIntType</xsl:text>
	</xsl:variable>

	<xsl:variable name="floatTypeID">
		<xsl:text>_iXAad4PGEduaib1rbFloatType</xsl:text>
	</xsl:variable>

	<xsl:variable name="doubleTypeID">
		<xsl:text>_iXAad4PGEduaib1rbDoubleType</xsl:text>
	</xsl:variable>

	<xsl:variable name="longTypeID">
		<xsl:text>_iXAad4PGEduaib1rbLongType</xsl:text>
	</xsl:variable>

	<xsl:variable name="StringTypeID">
		<xsl:text>_iXAad4PGEduaib1rbStringType</xsl:text>
	</xsl:variable>

	<xsl:variable name="booleanTypeID">
		<xsl:text>_iXAad4PGEduaib1rbBooleanType</xsl:text>
	</xsl:variable>

	<xsl:variable name="defaultIntegerTypeID">
		<xsl:text>_iXAad4PGEduaib1rbDefaultIntegerType</xsl:text>
	</xsl:variable>





	<xsl:template match="text()|@*">
		<xsl:value-of select="."/>
	</xsl:template>
	
	<xsl:template match="text()|@*"/>
	
	<xsl:template match="xmi:XMI">
		<xsl:apply-templates select="uml:Model"/>
	</xsl:template>
	
	<xsl:template match="uml:Model">
		<xmi:XMI xmi:version="2.1" 
			xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore"
			xmlns:xmi="http://schema.omg.org/spec/XMI/2.1" 
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
			xmlns:MusicProfile__="http:///MusicProfile.profile.uml"
			xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML" 
			xsi:schemaLocation="http:///MusicProfile.profile.uml MusicProfile.profile.uml#_iXAZdIPGEduaib1rbQg5jQ"> 
		<uml:Model xmi:id="_iXAadoPGEduaib1rbQg5jQ">
			<xsl:attribute name="name">
				<xsl:value-of select="@name"/>
			</xsl:attribute>
			<profileApplication xmi:id="_KQ6_AqASEdyZsb7rKRRz_g">
				<eAnnotations xmi:id="_KQ6_A6ASEdyZsb7rKRRz_g" source="http://www.eclipse.org/uml2/2.0.0/UML">
					<references xmi:type="ecore:EPackage" href="pathmap://UML_PROFILES/Standard.profile.uml#_yzU58YinEdqtvbnfB2L_5w"/>
				</eAnnotations>
				<appliedProfile href="pathmap://UML_PROFILES/Standard.profile.uml#_0"/>
			</profileApplication>
			<profileApplication xmi:id="_RCWV4KAaEdyZsb7rKRRz_g">
				<eAnnotations xmi:id="_RCgG4KAaEdyZsb7rKRRz_g" source="http://www.eclipse.org/uml2/2.0.0/UML">
					<references xmi:type="ecore:EPackage" href="MusicProfile.profile.uml#_0"/>
				</eAnnotations>
				<appliedProfile href="MusicProfile.profile.uml#_0"/>
			</profileApplication>
			<packageImport xmi:id="_KQ6_AaASEdyZsb7rKRRz_g">
				<importedPackage xmi:type="uml:Model" href="pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml#_0"/>
			</packageImport>
			<packagedElement xmi:type="uml:PrimitiveType" xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
				<xsl:attribute name="name">
					<xsl:text>int</xsl:text>
				</xsl:attribute>
				<xsl:attribute name="xmi:id">
					<xsl:value-of select="$intTypeID"/>
				</xsl:attribute>
			</packagedElement>
			<packagedElement xmi:type="uml:PrimitiveType" xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
				<xsl:attribute name="name">
					<xsl:text>float</xsl:text>
				</xsl:attribute>
				<xsl:attribute name="xmi:id">
					<xsl:value-of select="$floatTypeID"/>
				</xsl:attribute>
			</packagedElement>
			<packagedElement xmi:type="uml:PrimitiveType" xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
				<xsl:attribute name="name">
					<xsl:text>double</xsl:text>
				</xsl:attribute>
				<xsl:attribute name="xmi:id">
					<xsl:value-of select="$doubleTypeID"/>
				</xsl:attribute>
			</packagedElement>
			<packagedElement xmi:type="uml:PrimitiveType" xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
				<xsl:attribute name="name">
					<xsl:text>String</xsl:text>
				</xsl:attribute>
				<xsl:attribute name="xmi:id">
					<xsl:value-of select="$StringTypeID"/>
				</xsl:attribute>
			</packagedElement>
			<packagedElement xmi:type="uml:PrimitiveType" xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
				<xsl:attribute name="name">
					<xsl:text>boolean</xsl:text>
				</xsl:attribute>
				<xsl:attribute name="xmi:id">
					<xsl:value-of select="$booleanTypeID"/>
				</xsl:attribute>
			</packagedElement>
			<packagedElement xmi:type="uml:PrimitiveType" xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
				<xsl:attribute name="name">
					<xsl:text>long</xsl:text>
				</xsl:attribute>
				<xsl:attribute name="xmi:id">
					<xsl:value-of select="$longTypeID"/>
				</xsl:attribute>
			</packagedElement>
			<packagedElement xmi:type="uml:PrimitiveType" xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
				<xsl:attribute name="name">
					<xsl:text>defaultInteger</xsl:text>
				</xsl:attribute>
				<xsl:attribute name="xmi:id">
					<xsl:value-of select="$defaultIntegerTypeID"/>
				</xsl:attribute>
			</packagedElement>
			<xsl:apply-templates select="ownedMember[@xmi:type='uml:Package']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
		</uml:Model>
		<xsl:call-template name="DealWithStereotypes"/>
		</xmi:XMI>
	</xsl:template>
	
	<xsl:template name="DealWithStereotypes">
		<xsl:for-each select="ownedMember[@xmi:type='uml:Package']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:call-template name="AddStereotypesUML21">
				<xsl:with-param name="elementID" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
				<xsl:with-param name="type" select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:call-template>
			<xsl:call-template name="DealWithStereotypes"/>
		</xsl:for-each>
		<xsl:for-each select="ownedMember[@xmi:type='uml:Class']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:call-template name="AddStereotypesUML21">
				<xsl:with-param name="elementID" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
				<xsl:with-param name="type" select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:call-template>
			<xsl:call-template name="DealWithStereotypes"/>
		</xsl:for-each>
		<xsl:for-each select="nestedClassifier[@xmi:type='uml:Class']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:call-template name="AddStereotypesUML21">
				<xsl:with-param name="elementID" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
				<xsl:with-param name="type" select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:call-template>
			<xsl:call-template name="DealWithStereotypes"/>
		</xsl:for-each>
		<xsl:for-each select="ownedMember[@xmi:type='uml:Node']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:call-template name="AddStereotypesUML21">
				<xsl:with-param name="elementID" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
				<xsl:with-param name="type" select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:call-template>
			<xsl:call-template name="DealWithStereotypes"/>
		</xsl:for-each>
		<xsl:for-each select="nestedNode[@xmi:type='uml:Node']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:call-template name="AddStereotypesUML21">
				<xsl:with-param name="elementID" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
				<xsl:with-param name="type" select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:call-template>
			<xsl:call-template name="DealWithStereotypes"/>
		</xsl:for-each>
		<xsl:for-each select="nestedClassifier[@xmi:type='uml:Component']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:call-template name="AddStereotypesUML21">
				<xsl:with-param name="elementID" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
				<xsl:with-param name="type" select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:call-template>
			<xsl:call-template name="DealWithStereotypes"/>
		</xsl:for-each>
		<xsl:for-each select="ownedMember[@xmi:type='uml:Constraint']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:call-template name="AddStereotypesUML21">
				<xsl:with-param name="elementID" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
				<xsl:with-param name="type" select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:call-template>
			<xsl:call-template name="DealWithStereotypes"/>
		</xsl:for-each>
		<xsl:for-each select="ownedPort[@xmi:type='uml:Port']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:call-template name="AddStereotypesUML21">
				<xsl:with-param name="elementID" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
				<xsl:with-param name="type" select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:call-template>
			<xsl:call-template name="DealWithStereotypes"/>
		</xsl:for-each>
		<xsl:for-each select="qualifier[@xmi:type='uml:Port']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:call-template name="AddStereotypesUML21">
				<xsl:with-param name="elementID" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
				<xsl:with-param name="type" select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:call-template>
		<xsl:call-template name="DealWithStereotypes"/>
		</xsl:for-each>
		<xsl:for-each select="ownedAttribute[@xmi:type='uml:Property']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:call-template name="AddStereotypesUML21">
				<xsl:with-param name="elementID" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
				<xsl:with-param name="type" select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:call-template>
			<xsl:call-template name="AddAttributeStereotypesUML21">
				<xsl:with-param name="elementID" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
				<xsl:with-param name="type" select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:call-template>
			<xsl:call-template name="DealWithStereotypes"/>
		</xsl:for-each>
	</xsl:template>



	<xsl:template name="AddStereotypesUML21">
		<xsl:param name="elementID"/>
		<xsl:param name="type"/>
		<xsl:for-each select="/xmi:XMI/xmi:Extension/elements/element" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:if test="$elementID=@xmi:idref" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
				<xsl:if test="string-length(properties/@stereotype)&gt;0">
					<xsl:variable name="StereotypeString">
						<xsl:text>MusicProfile__:MusicProfile__</xsl:text><xsl:value-of select="properties/@stereotype"/>
					</xsl:variable>					
					<xsl:variable name="StereotypeString2">
						<xsl:text>MusicProfile__:MusicProfile__mContextMediation</xsl:text>
					</xsl:variable>
					
					<xsl:element name="{$StereotypeString}" namespace="http:///MusicProfile.profile.uml">
						<xsl:attribute name="xmi:id">
							<xsl:value-of select="$elementID"/><xsl:text>ST</xsl:text>
						</xsl:attribute>
						<xsl:if test="$type='uml:Package'">
							<xsl:attribute name="base_Package">
								<xsl:value-of select="$elementID"/>
							</xsl:attribute>
						</xsl:if>
						<xsl:if test="$type='uml:Class'">
							<xsl:attribute name="base_Class">
								<xsl:value-of select="$elementID"/>
							</xsl:attribute>
						</xsl:if>
						<xsl:if test="$type='uml:Node'">
							<xsl:attribute name="base_Node">
								<xsl:value-of select="$elementID"/>
							</xsl:attribute>
						</xsl:if>
						<xsl:if test="$type='uml:Component'">
							<xsl:attribute name="base_Artifact">
								<xsl:value-of select="$elementID"/><xsl:text>AR</xsl:text>
							</xsl:attribute>
						</xsl:if>
						<xsl:if test="$type='uml:Constraint'">
							<xsl:attribute name="base_Constraint">
								<xsl:value-of select="$elementID"/>
							</xsl:attribute>
						</xsl:if>
						<xsl:if test="$type='uml:Port'">
							<xsl:attribute name="base_Port">
								<xsl:value-of select="$elementID"/>
							</xsl:attribute>
						</xsl:if>
						<xsl:if test="$type='uml:Property'">
							<xsl:attribute name="base_Property">
								<xsl:value-of select="$elementID"/>
							</xsl:attribute>
						</xsl:if>
						<xsl:if test="$type='uml:Part'">
							<xsl:attribute name="base_Property">
								<xsl:value-of select="$elementID"/>
							</xsl:attribute>
						</xsl:if>
						<xsl:if test="$type='uml:Note'">
							<xsl:attribute name="base_Comment">
								<xsl:value-of select="$elementID"/>
							</xsl:attribute>
						</xsl:if>
					</xsl:element>
					<xsl:if test="properties/@stereotype='mContextMediation'">
						<xsl:element name="{$StereotypeString2}" namespace="http:///MusicProfile.profile.uml">
							<xsl:attribute name="xmi:id">
								<xsl:value-of select="$elementID"/><xsl:text>NST</xsl:text>
							</xsl:attribute>
							<xsl:attribute name="base_Comment">
								<xsl:value-of select="$elementID"/><xsl:text>N</xsl:text>
							</xsl:attribute>
						</xsl:element>
					</xsl:if>
				</xsl:if>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>	
	
	<xsl:template name="AddAttributeStereotypesUML21">
		<xsl:param name="elementID"/>
		<xsl:param name="type"/>
		<xsl:for-each select="/xmi:XMI/xmi:Extension/elements/element/attributes/attribute" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:if test="$elementID=@xmi:idref" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
				<xsl:if test="string-length(stereotype/@stereotype)&gt;0">
					<xsl:variable name="StereotypeString">
						<xsl:text>MusicProfile__:MusicProfile__</xsl:text><xsl:value-of select="stereotype/@stereotype"/>
					</xsl:variable>
					<xsl:element name="{$StereotypeString}" namespace="http:///MusicProfile.profile.uml">
						<xsl:attribute name="xmi:id">
							<xsl:value-of select="$elementID"/><xsl:text>ST</xsl:text>
						</xsl:attribute>
						<xsl:if test="$type='uml:Property'">
							<xsl:attribute name="base_Property">
								<xsl:value-of select="$elementID"/>
							</xsl:attribute>
						</xsl:if>
					</xsl:element>
				</xsl:if>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>	

	<xsl:template match="ownedMember[@xmi:type='uml:Package']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
		<packagedElement
			xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML"
		>
			<xsl:attribute name="xmi:type">
				<xsl:value-of select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="xmi:id">
				<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="name">
				<xsl:value-of select="@name"/>
			</xsl:attribute>
			<xsl:attribute name="visibility">
				<xsl:value-of select="@visibility"/>
			</xsl:attribute>
			<xsl:apply-templates select="ownedMember[@xmi:type='uml:Package']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			<xsl:apply-templates select="ownedMember[@xmi:type='uml:Class']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			<xsl:apply-templates select="ownedElement[@xmi:type='uml:Realization']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			<xsl:apply-templates select="ownedElement[@xmi:type='uml:Dependency']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			<xsl:apply-templates select="ownedMember[@xmi:type='uml:Association']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			<xsl:apply-templates select="ownedMember[@xmi:type='uml:Node']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			<xsl:apply-templates select="ownedMember[@xmi:type='uml:Constraint']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
		</packagedElement>
	</xsl:template>
	<xsl:template match="ownedMember[@xmi:type='uml:Class']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
		<packagedElement xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
			<xsl:attribute name="xmi:type">
				<xsl:value-of select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="xmi:id">
				<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="name">
				<xsl:value-of select="@name"/>
			</xsl:attribute>
			<xsl:attribute name="visibility">
				<xsl:value-of select="@visibility"/>
			</xsl:attribute>
			<xsl:apply-templates select="nestedClassifier[@xmi:type='uml:Class']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			<xsl:apply-templates select="ownedPort[@xmi:type='uml:Port']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			<xsl:apply-templates select="ownedAttribute[@xmi:type='uml:Property']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			<xsl:apply-templates select="ownedConnector[@xmi:type='uml:Connector']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			<xsl:call-template name="AddClassConstraints">
				<xsl:with-param name="elementID" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:call-template>
			<xsl:call-template name="AddAssociationRoles">
				<xsl:with-param name="elementID" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:call-template>
			<xsl:call-template name="AddClassComments">
				<xsl:with-param name="elementIDREF" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:call-template>
		</packagedElement>
	</xsl:template>
	<xsl:template match="ownedElement[@xmi:type='uml:Realization']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
		<packagedElement
			xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML"
		>
			<xsl:attribute name="xmi:type">
				<xsl:text>uml:Dependency</xsl:text>
			</xsl:attribute>
			<xsl:attribute name="xmi:id">
				<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="name">
				<xsl:value-of select="@name"/>
			</xsl:attribute>
			<xsl:attribute name="supplier">
				<xsl:value-of select="@supplier"/>
			</xsl:attribute>
			<xsl:attribute name="client">
				<xsl:value-of select="@client"/>
			</xsl:attribute>
		</packagedElement>
	</xsl:template>
	<xsl:template match="ownedElement[@xmi:type='uml:Dependency']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
		<packagedElement
			xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML"
		>
			<xsl:attribute name="xmi:type">
				<xsl:value-of select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="xmi:id">
				<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="name">
				<xsl:value-of select="@name"/>
			</xsl:attribute>
			<xsl:attribute name="supplier">
				<xsl:value-of select="@supplier"/>
			</xsl:attribute>
			<xsl:attribute name="client">
				<xsl:value-of select="@client"/>
			</xsl:attribute>
		</packagedElement>
	</xsl:template>
	
	<xsl:template match="nestedClassifier[@xmi:type='uml:Class']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
		<nestedClassifier xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
			<xsl:attribute name="xmi:type">
				<xsl:value-of select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="xmi:id">
				<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="name">
				<xsl:value-of select="@name"/>
			</xsl:attribute>
			<xsl:attribute name="visibility">
				<xsl:value-of select="@visibility"/>
			</xsl:attribute>
			<xsl:apply-templates select="nestedClassifier[@xmi:type='uml:Class']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			<xsl:apply-templates select="ownedPort[@xmi:type='uml:Port']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			<xsl:apply-templates select="ownedAttribute[@xmi:type='uml:Property']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			<xsl:apply-templates select="ownedConnector[@xmi:type='uml:Connector']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			<xsl:call-template name="AddAssociationRoles">
				<xsl:with-param name="elementID" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:call-template>
		</nestedClassifier>
	</xsl:template>

	<xsl:template match="ownedPort[@xmi:type='uml:Port']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
		<ownedPort xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
			<xsl:attribute name="xmi:type">
				<xsl:value-of select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="xmi:id">
				<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="name">
				<xsl:value-of select="@name"/>
			</xsl:attribute>
			<xsl:attribute name="visibility">
				<xsl:value-of select="@visibility"/>
			</xsl:attribute>
			<xsl:attribute name="aggregation">
				<xsl:value-of select="@aggregation"/>
			</xsl:attribute>
			<xsl:attribute name="end">
				<xsl:call-template name="AddConnectorEnd">
					<xsl:with-param name="roleID" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
				</xsl:call-template>
			</xsl:attribute>			
		</ownedPort>
	</xsl:template>
	<xsl:template match="ownedAttribute[@xmi:type='uml:Property']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
		<ownedAttribute xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
			<xsl:attribute name="xmi:type">
				<xsl:value-of select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="xmi:id">
				<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="name">
				<xsl:value-of select="@name"/>
			</xsl:attribute>
			<xsl:choose>	
				<xsl:when test="qualifier/@xmi:type='uml:Port'" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
					<xsl:attribute name="visibility">
						<xsl:value-of select="@visibility"/>
					</xsl:attribute>
					<xsl:attribute name="aggregation">
						<xsl:value-of select="@aggregation"/>
					</xsl:attribute>
					<xsl:apply-templates select="qualifier[@xmi:type='uml:Port']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>-->			
				</xsl:when>
				<xsl:otherwise>
					<xsl:if test="string-length(type/@xmi:idref) &gt; 0" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
						<xsl:call-template name="AddAttributeType">
							<xsl:with-param name="elementIDREF" select="type/@xmi:idref" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
						</xsl:call-template>
					</xsl:if>	
					<xsl:if test="string-length(type/@xmi:idref) = 0" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
						<xsl:call-template name="AddAttributeType2">
							<xsl:with-param name="elementIDREF" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
						</xsl:call-template>
					</xsl:if>
					<xsl:if test="string-length(lowerValue/@value) &gt; 0">
						<lowerValue xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
							<xsl:attribute name="xmi:type">
								<xsl:value-of select="lowerValue/@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
							</xsl:attribute>
							<xsl:attribute name="xmi:id">
								<xsl:value-of select="lowerValue/@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
							</xsl:attribute>
							<xsl:attribute name="value">
								<xsl:value-of select="lowerValue/@value"/>
							</xsl:attribute>				
						</lowerValue>
						<upperValue xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
							<xsl:attribute name="xmi:type">
								<xsl:value-of select="upperValue/@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
							</xsl:attribute>
							<xsl:attribute name="xmi:id">
								<xsl:value-of select="upperValue/@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
							</xsl:attribute>
							<xsl:attribute name="value">
								<xsl:value-of select="upperValue/@value"/>
							</xsl:attribute>								
						</upperValue>
						<defaultValue xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
							<xsl:attribute name="xmi:type">
								<xsl:text>uml:LiteralString</xsl:text>
							</xsl:attribute>
							<xsl:attribute name="xmi:id">
								<xsl:value-of select="defaultValue/@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
							</xsl:attribute>
							<xsl:attribute name="value">
								<xsl:value-of select="defaultValue/@value"/>
							</xsl:attribute>												
						</defaultValue>
					</xsl:if>
				</xsl:otherwise>
			</xsl:choose>
		</ownedAttribute>
	</xsl:template>

	<xsl:template match="qualifier[@xmi:type='uml:Port']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
		<qualifier xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
			<xsl:attribute name="xmi:type">
				<xsl:value-of select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="xmi:id">
				<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="name">
				<xsl:value-of select="@name"/>
			</xsl:attribute>
			<xsl:attribute name="visibility">
				<xsl:value-of select="@visibility"/>
			</xsl:attribute>
			<xsl:attribute name="aggregation">
				<xsl:value-of select="@aggregation"/>
			</xsl:attribute>
			<xsl:attribute name="end">
				<xsl:call-template name="AddConnectorEnd">
					<xsl:with-param name="roleID" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
				</xsl:call-template>
			</xsl:attribute>			
		</qualifier>
	</xsl:template>

	<xsl:template match="ownedConnector[@xmi:type='uml:Connector']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
		<ownedConnector xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
			<xsl:attribute name="xmi:type">
				<xsl:value-of select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="xmi:id">
				<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="visibility">
				<xsl:value-of select="@visibility"/>
			</xsl:attribute>
			<xsl:call-template name="AddConnectorComments">
				<xsl:with-param name="elementIDREF" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:call-template>
			<xsl:apply-templates select="end[@xmi:type='uml:ConnectorEnd']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
		</ownedConnector>
	</xsl:template>
	
	<xsl:template match="end[@xmi:type='uml:ConnectorEnd']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
		<end xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
			<xsl:attribute name="xmi:type">
				<xsl:value-of select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="xmi:id">
				<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="role">
				<xsl:value-of select="@role"/>
			</xsl:attribute>
		</end>
	</xsl:template>

	<xsl:template match="ownedMember[@xmi:type='uml:Association']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
		<xsl:variable name="myAssID" select=" @xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
		<packagedElement
			xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML"
		>
			<xsl:attribute name="xmi:type">
				<xsl:value-of select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="xmi:id">
				<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="name">
				<xsl:value-of select="@name" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="memberEnd">
				<xsl:for-each select="ownedEnd/type">
					<xsl:value-of select="$myAssID" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
					<xsl:if test="position()!=last()"><xsl:text>FI </xsl:text></xsl:if>
					<xsl:if test="position()=last()"><xsl:text>FILA</xsl:text></xsl:if>
				</xsl:for-each>
			</xsl:attribute>
		</packagedElement>
	</xsl:template>

	<xsl:template match="ownedMember[@xmi:type='uml:Node']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
		<packagedElement xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
			<xsl:attribute name="xmi:type">
				<xsl:value-of select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="xmi:id">
				<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="name">
				<xsl:value-of select="@name"/>
			</xsl:attribute>
			<xsl:attribute name="visibility">
				<xsl:value-of select="@visibility"/>
			</xsl:attribute>
			<xsl:attribute name="clientDependency">
				<xsl:for-each select="nestedClassifier[@xmi:type='uml:Component']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
					<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
					<xsl:if test="position()!=last()">
						<xsl:text> </xsl:text>
					</xsl:if>
				</xsl:for-each>
			</xsl:attribute>
			<xsl:call-template name="AddDeployments">
				<xsl:with-param name="elementID" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:call-template>
			<xsl:apply-templates select="nestedNode[@xmi:type='uml:Node']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
		</packagedElement>
		<xsl:call-template name="AddDeploymentsAsArtifacts"/>
	</xsl:template>
	
	<xsl:template match="nestedNode[@xmi:type='uml:Node']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
		<nestedNode xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
			<xsl:attribute name="xmi:type">
				<xsl:value-of select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="xmi:id">
				<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="name">
				<xsl:value-of select="@name"/>
			</xsl:attribute>
			<xsl:attribute name="visibility">
				<xsl:value-of select="@visibility"/>
			</xsl:attribute>
			<xsl:attribute name="clientDependency">
				<xsl:for-each select="nestedClassifier[@xmi:type='uml:Component']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
					<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
					<xsl:if test="position()!=last()">
						<xsl:text> </xsl:text>
					</xsl:if>
				</xsl:for-each>
			</xsl:attribute>			
			<xsl:call-template name="AddDeployments">
				<xsl:with-param name="elementID" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:call-template>
			<xsl:apply-templates select="nestedNode[@xmi:type='uml:Node']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
		</nestedNode>
	</xsl:template>

	<xsl:template match="ownedMember[@xmi:type='uml:Constraint']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
		<ownedRule xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
			<xsl:attribute name="xmi:id">
				<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<xsl:attribute name="name">
				<xsl:text>ConstraintName</xsl:text>
			</xsl:attribute>
			<xsl:attribute name="constrainedElement">
				<xsl:value-of select="constrainedElement/@xmi:idref" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			</xsl:attribute>
			<specification xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
				<xsl:attribute name="xmi:type">
					<xsl:value-of select="specification/@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
				</xsl:attribute>
				<xsl:attribute name="xmi:id">
					<xsl:value-of select="specification/@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
				</xsl:attribute>
				<xsl:attribute name="language">
					<xsl:text>text</xsl:text>
				</xsl:attribute>
				<body xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
					<xsl:value-of select="specification/body"/>	
				</body>
			</specification>
		</ownedRule>
	</xsl:template>

	
	<xsl:template name="AddConnectorEnd">
		<xsl:param name="roleID"/>
		<xsl:for-each select="../ownedConnector">
			<xsl:call-template name="AddConnectorEnd2">
				<xsl:with-param name="roleID" select="$roleID"/>
			</xsl:call-template>
		</xsl:for-each>
		<xsl:for-each select="../../ownedConnector">
			<xsl:call-template name="AddConnectorEnd2">
				<xsl:with-param name="roleID" select="$roleID"/>
			</xsl:call-template>
		</xsl:for-each>	
		<xsl:variable name="memberID" select="../@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
		<xsl:for-each select="../../ownedMember/ownedConnector">
			<xsl:if test="../@xmi:id!=$memberID" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
				<xsl:call-template name="AddConnectorEnd2">
					<xsl:with-param name="roleID" select="$roleID"/>
				</xsl:call-template>
			</xsl:if>
		</xsl:for-each>				
	</xsl:template>

	<xsl:template name="AddConnectorEnd2">
		<xsl:param name="roleID"/>
		<xsl:for-each select="end">
			<xsl:if test="$roleID=@role">
				<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/><xsl:text> </xsl:text>
			</xsl:if>
		</xsl:for-each>		
	</xsl:template>
	
	<xsl:template name="AddDeploymentsAsArtifacts">
		<xsl:for-each select="nestedClassifier[@xmi:type='uml:Component']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<packagedElement xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
				<xsl:attribute name="xmi:type">
					<xsl:text>uml:Artifact</xsl:text>
				</xsl:attribute>
				<xsl:attribute name="xmi:id">
					<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/><xsl:text>AR</xsl:text>
				</xsl:attribute>
				<xsl:attribute name="name">
					<xsl:value-of select="@name"/>
				</xsl:attribute>
			</packagedElement>
		</xsl:for-each>
		<xsl:for-each select="nestedNode[@xmi:type='uml:Node']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:call-template name="AddDeploymentsAsArtifacts"/>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="AddDeployments">
		<xsl:param name="elementID"/>
		<xsl:for-each select="nestedClassifier[@xmi:type='uml:Component']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<deployment xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
				<xsl:attribute name="xmi:id">
					<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
				</xsl:attribute>
				<xsl:attribute name="name">
					<xsl:text>Unbekannter Name</xsl:text>
				</xsl:attribute>
				<xsl:attribute name="client">
					<xsl:value-of select="$elementID"/>
				</xsl:attribute>
				<xsl:attribute name="supplier">
					<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/><xsl:text>AR</xsl:text>
				</xsl:attribute>
				<xsl:attribute name="deployedArtifact">
					<xsl:value-of select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/><xsl:text>AR</xsl:text>
				</xsl:attribute>
			</deployment>
		</xsl:for-each>		
	</xsl:template>


	<xsl:template name="AddStereotypes">
		<xsl:param name="elementID"/>	
		<xsl:for-each select="/xmi:XMI/xmi:Extension/elements/element" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:if test="$elementID=@xmi:idref" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
				<xsl:if test="string-length(properties/@stereotype)&gt;0">
				<eAnnotations>
					<xsl:attribute name="xmi:id">
						<xsl:value-of select="$elementID"/><xsl:text>AN</xsl:text>
					</xsl:attribute>
					<xsl:attribute name="source">
						<xsl:text>appliedStereotypes</xsl:text>
					</xsl:attribute>
					<contents>
						<xsl:attribute name="xmi:type">
							<xsl:value-of select="$ProfilePrefix"/><xsl:value-of select="properties/@stereotype"/>
						</xsl:attribute>
						<xsl:attribute name="xmi:id">
							<xsl:value-of select="$elementID"/><xsl:text>ST</xsl:text>
						</xsl:attribute>
					</contents>
				</eAnnotations>
				</xsl:if>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>
	
	<xsl:template name="AddStereotypesAttributes">
		<xsl:param name="elementID"/>	
		<xsl:for-each select="/xmi:XMI/xmi:Extension/elements/element/attributes/attribute" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:if test="$elementID=@xmi:idref" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
				<xsl:if test="string-length(stereotype/@stereotype)&gt;0">
				<eAnnotations>
					<xsl:attribute name="xmi:id">
						<xsl:value-of select="$elementID"/><xsl:text>AN</xsl:text>
					</xsl:attribute>
					<xsl:attribute name="source">
						<xsl:text>appliedStereotypes</xsl:text>
					</xsl:attribute>
					<contents>
						<xsl:attribute name="xmi:type">
							<xsl:value-of select="$ProfilePrefix"/><xsl:value-of select="stereotype/@stereotype"/>
						</xsl:attribute>
						<xsl:attribute name="xmi:id">
							<xsl:value-of select="$elementID"/><xsl:text>ST</xsl:text>
						</xsl:attribute>
					</contents>
				</eAnnotations>
				</xsl:if>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>


	<xsl:template name="AddClassConstraints">
		<xsl:param name="elementID"/>	
		<xsl:for-each select="/xmi:XMI/xmi:Extension/elements/element" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:if test="$elementID=@xmi:idref" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
				<xsl:if test="string-length(constraints/constraint/@name)&gt;0">
					<ownedAttribute xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
						<xsl:attribute name="name">
							<xsl:text>FeatureConstraint</xsl:text>
						</xsl:attribute>
						<xsl:attribute name="xmi:id">
							<xsl:value-of select="$elementID"/><xsl:text>AT</xsl:text>
						</xsl:attribute>
						<xsl:attribute name="isUnique">
							<xsl:text>false</xsl:text>
						</xsl:attribute>
						<type xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
							<xsl:attribute name="xmi:type">
								<xsl:text>uml:PrimitiveType</xsl:text>
							</xsl:attribute>
							<xsl:attribute name="name">
								<xsl:text>String</xsl:text>
							</xsl:attribute>
						</type>
						<defaultValue xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
							<xsl:attribute name="xmi:type">
								<xsl:text>uml:LiteralString</xsl:text>
							</xsl:attribute>
							<xsl:attribute name="xmi:id">
								<xsl:value-of select="$elementID"/><xsl:text>DV</xsl:text>
							</xsl:attribute>
							<xsl:attribute name="value">
								<xsl:value-of select="constraints/constraint/@name"/>
							</xsl:attribute>
						</defaultValue>
					</ownedAttribute>
				</xsl:if>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="AddAttributeType">
		<xsl:param name="elementIDREF"/>	
			<xsl:for-each select="/xmi:XMI/uml:Model/ownedMember/EAStub" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
				<xsl:if test="$elementIDREF=@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
					<xsl:attribute name="type">
						<xsl:if test="@name='int'">
							<xsl:value-of select="$intTypeID"/>
						</xsl:if>
						<xsl:if test="@name='float'">
							<xsl:value-of select="$floatTypeID"/>
						</xsl:if>
						<xsl:if test="@name='double'">
							<xsl:value-of select="$doubleTypeID"/>
						</xsl:if>
						<xsl:if test="@name='boolean'">
							<xsl:value-of select="$booleanTypeID"/>
						</xsl:if>
						<xsl:if test="@name='long'">
							<xsl:value-of select="$longTypeID"/>
						</xsl:if>
						<xsl:if test="@name='String'">
							<xsl:value-of select="$StringTypeID"/>
						</xsl:if>
						<xsl:if test="@name='defaultInteger'">
							<xsl:value-of select="$defaultIntegerTypeID"/>
						</xsl:if>
					</xsl:attribute>
				</xsl:if>
			</xsl:for-each>
	</xsl:template>

	<xsl:template name="AddAttributeType2">
		<xsl:param name="elementIDREF"/>	
		<xsl:for-each select="/xmi:XMI/xmi:Extension/elements/element/attributes/attribute" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:if test="$elementIDREF=@xmi:idref" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
				<xsl:if test="string-length(properties/@type)&gt;0">
					<xsl:attribute name="type">
						<xsl:if test="properties/@type='int'">
							<xsl:value-of select="$intTypeID"/>
						</xsl:if>
						<xsl:if test="properties/@type='float'">
							<xsl:value-of select="$floatTypeID"/>
						</xsl:if>
						<xsl:if test="properties/@type='double'">
							<xsl:value-of select="$doubleTypeID"/>
						</xsl:if>
						<xsl:if test="properties/@type='boolean'">
							<xsl:value-of select="$booleanTypeID"/>
						</xsl:if>
						<xsl:if test="properties/@type='long'">
							<xsl:value-of select="$longTypeID"/>
						</xsl:if>
						<xsl:if test="properties/@type='String'">
							<xsl:value-of select="$StringTypeID"/>
						</xsl:if>
						<xsl:if test="properties/@type='defaultInteger'">
							<xsl:value-of select="$defaultIntegerTypeID"/>
						</xsl:if>
					</xsl:attribute>
				</xsl:if>
				<xsl:if test="string-length(properties/@type) = 0">
					<xsl:attribute name="type">
						<xsl:value-of select="$defaultIntegerTypeID"/>
					</xsl:attribute>
				</xsl:if>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>
	

	<xsl:template name="AddAssociationRoles">
		<xsl:param name="elementID"/>	
		<xsl:for-each select="//ownedMember[@xmi:type='uml:Association']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:variable name="assid" select="@xmi:id" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
			<xsl:for-each select="ownedEnd">	
				<xsl:if test="$elementID=type/@xmi:idref" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
					<ownedAttribute	xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
						<xsl:attribute name="xmi:id">
							<xsl:value-of select="$assid"/>
							<xsl:text>FI</xsl:text>
							<xsl:if test="position()=last()"><xsl:text>LA</xsl:text></xsl:if>
						</xsl:attribute>
						<xsl:for-each select="../ownedEnd">
							<xsl:if test="$elementID=type/@xmi:idref" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
								<xsl:attribute name="name">
									<xsl:value-of select="@name"/>
								</xsl:attribute>			
							</xsl:if>
							<xsl:if test="$elementID!=type/@xmi:idref" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
								<xsl:attribute name="type">
									<xsl:value-of select="type/@xmi:idref" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
								</xsl:attribute>			
							</xsl:if>
						</xsl:for-each>
						<xsl:attribute name="association">
							<xsl:value-of select="$assid"/>
						</xsl:attribute>
						<upperValue xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
							<xsl:attribute name="xmi:type">
								<xsl:text>uml:LiteralUnlimitedNatural</xsl:text>
							</xsl:attribute>
							<xsl:attribute name="xmi:id">
								<xsl:value-of select="$assid"/>
								<xsl:text>UV</xsl:text>
								<xsl:if test="position()=last()"><xsl:text>LA</xsl:text></xsl:if>
							</xsl:attribute>
							<xsl:attribute name="value">
								<xsl:text>1</xsl:text>
							</xsl:attribute>
						</upperValue>
						<lowerValue xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
							<xsl:attribute name="xmi:type">
								<xsl:text>uml:LiteralInteger</xsl:text>
							</xsl:attribute>
							<xsl:attribute name="xmi:id">
								<xsl:value-of select="$assid"/>
								<xsl:text>LV</xsl:text>
								<xsl:if test="position()=last()"><xsl:text>LA</xsl:text></xsl:if>
							</xsl:attribute>
							<xsl:attribute name="value">
								<xsl:text>1</xsl:text>
							</xsl:attribute>
						</lowerValue>
					</ownedAttribute>
				</xsl:if>
			</xsl:for-each>
		</xsl:for-each>
	</xsl:template>
	
	<xsl:template name="AddClassComments">
		<xsl:param name="elementIDREF"/>
		<xsl:for-each select="/xmi:XMI/xmi:Extension/elements/element[@xmi:type='uml:Note']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:if test="$elementIDREF=links/NoteLink/@end" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
				<ownedComment xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
					<xsl:attribute name="xmi:type">
						<xsl:value-of select="@xmi:type" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1"/>
					</xsl:attribute>
					<xsl:attribute name="xmi:id">
						<xsl:value-of select="links/NoteLink/@start"/>
					</xsl:attribute>
					<body xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
						<xsl:value-of select="properties/@documentation"/>
					</body>
				</ownedComment>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>

	<xsl:template name="AddConnectorComments">
		<xsl:param name="elementIDREF"/>
		<xsl:variable name="refText">
			<xsl:text>idref1=</xsl:text><xsl:value-of select="$elementIDREF"/><xsl:text>;</xsl:text>
		</xsl:variable>
		<xsl:for-each select="/xmi:XMI/xmi:Extension/elements/element[@xmi:type='uml:Note']" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
			<xsl:if test="$refText=extendedProperties/@relatedlinks" xmlns:xmi="http://schema.omg.org/spec/XMI/2.1">
				<ownedComment xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
					<xsl:attribute name="xmi:type">
						<xsl:text>uml:Comment</xsl:text>
					</xsl:attribute>
					<xsl:attribute name="xmi:id">
						<xsl:value-of select="@xmi:idref"/><xsl:text>N</xsl:text>
					</xsl:attribute>
					<body xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML">
						<xsl:value-of select="properties/@documentation"/>
					</body>
				</ownedComment>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>
	
	
</xsl:stylesheet>